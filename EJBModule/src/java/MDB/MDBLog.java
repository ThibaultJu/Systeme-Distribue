/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDB;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

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
            System.out.println("-------Message recu par le MDB : " + tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(MDBLog.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }   
}
