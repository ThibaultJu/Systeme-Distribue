/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entities.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tibha
 */
@Stateless
public class EJBPatient implements EJBPatientRemote {

    @Override
    public String sayHello(String name) {
        return "Hello Patient" + name;
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
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
