/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tibha
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient c = new Patient();
        try
        {
            /*c.setIdPatient(2);
            c.setNom("Hooghen");
            c.setPrenom("Vincent");
            c.setLogin("Vince");
            
            em.persist(c);*/
            
            Patient p2 = em.find(Patient.class, 1);
            System.out.printf(p2.getPrenom());
            
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
    }
    
}
