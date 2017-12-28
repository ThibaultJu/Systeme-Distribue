/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDB;

import entities.*;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tibha
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/myTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myTopic")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/myTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
    ,
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "toMDB = true")
})
public class MDBLog implements MessageListener {
    
    public MDBLog() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            Calendar myCalendar = Calendar.getInstance();
            Date myDate = myCalendar.getTime();
            System.out.println("-------Message recu par le MDB : " + tm.getText());
            System.out.println("date fin analyse" + myDate);
            int id = parseInt(tm.getText());
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModulePU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Demande c = new Demande();
            try
            {
                c= em.find(Demande.class, id);                        
                em.getTransaction().commit();
            }
            catch(Exception e)
            {
                em.getTransaction().rollback();
            }
            finally
            {
                em.close();
            }
            Date dateDemande = c.getDateHeureDemande();
            System.out.println("date fin demande" + dateDemande);
            int secondes = MinutesBetween(dateDemande,myDate);
            int jours = secondes / (60 * 60 * 24);secondes = secondes % (60 * 60 * 24);
            int heures = secondes / (60 * 60);secondes = secondes % (60 * 60);
            int minutes = secondes / (60);secondes = secondes % (60);
            int sec= secondes ;
            System.out.println("Il aura fallu " + jours + " Jours " +  heures + " Heures " + minutes + " Minutes " + sec + " Secondes ");
        } catch (JMSException ex) {
            Logger.getLogger(MDBLog.class.getName()).log(Level.SEVERE, null, ex);
        }      
    } 
    public int MinutesBetween(Date d1, Date d2){
             return (int)( (d2.getTime() - d1.getTime()) / (1000));
     } 
    
    public Patient getPatient(int id)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModulePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient c = new Patient();
        try
        {
            /*c.setIdPatient(3);
            c.setNom("Hooghen");
            c.setPrenom("Vincent");
            c.setLogin("Vince");
            
            em.persist(c);*/
            
            Patient p2 = em.find(Patient.class, id);
            
            System.out.printf(p2.getNom());
            
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally
        {
            em.close();
        }
        return c;
    }
}
