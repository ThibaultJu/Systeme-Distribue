/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entities.*;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tibha
 */
@Stateless
@DeclareRoles("Medecin")
public class EJBPatient implements EJBPatientRemote {

    @Resource SessionContext ctx;
    @Override
    
    @RolesAllowed("Medecin")
    public String sayHello(String name) { 
        return "Hello Patient" + name;
    }

    @Override
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
            
            c= em.find(Patient.class, id);
            
            System.out.printf(c.getNom());
            
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

    @Override
    public Boolean CheckIdMedecin() {
        Principal callerPrincipal = ctx.getCallerPrincipal();
        System.out.printf("Caller principal : "+callerPrincipal.getName()); 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModulePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Vector<Medecin> m = new Vector<Medecin>();
        //Medecin m = new Medecin();
        m= (Vector<Medecin>)em.createQuery("SELECT m FROM Medecin m WHERE m.login LIKE :LogMedecin")
        .setParameter("LogMedecin", callerPrincipal.getName())
        .setMaxResults(1)
        .getResultList();
        System.out.printf(m.firstElement().getPrenom());
        em.getTransaction().commit();   
        if(m.firstElement().getLogin() != null)
            return true;
        else
            return false;
    }
}
