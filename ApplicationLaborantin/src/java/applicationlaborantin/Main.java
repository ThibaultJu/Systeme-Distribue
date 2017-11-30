/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationlaborantin;

import EJB.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.*;

/**
 *
 * @author tibha
 */
public class Main {

    @EJB
    private static EJBAnalysesRemote ejb_Analyses;
    private Queue queue = null;
    private Connection connection = null;
    private Session session = null;
   
    private MessageProducer producer = null;
    private MessageConsumer consumer = null;
    
    public static void main(String[] args) {
        System.out.println(ejb_Analyses.sayHello("Labo"));
        
        queue = top;
        connection = conn;
        session = sess;
        
        try
        {
            consumer = session.createConsumer(queue);
            consumer.setMessageListener(this);
            
            producer = session.createProducer(queue);
        } catch (JMSException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
