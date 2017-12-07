/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationmedecin;

import EJB.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Vince
 */
public class Main implements MessageListener{

    @EJB
    private static EJBAnalysesRemote ejb_Analyses;

    @EJB
    private static EJBPatientRemote sessionBeanRemote;
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(sessionBeanRemote.sayHello("Jean-claude Van Damme"));
        System.out.println(ejb_Analyses.sayHello("Jean-claude Van Damme"));
    }

    @Override
    public void onMessage(Message message) {
        try
        {
            TextMessage tm = (TextMessage)message;
            System.out.println("Message = " + tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
