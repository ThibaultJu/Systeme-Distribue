/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author tibha
 */


@Stateless
public class EJBAnalyses implements EJBAnalysesRemote {

    @Resource(mappedName = "jms/myTopic")
    private Topic myTopic;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Resource(mappedName = "jms/myQueue")
    private Queue myQueue;


    @Override
    public String sayHello(String name) {
        return"Hello analyse" + name;
    }

    @Override
    public void sendMessageQueue() {
        
        sendJMSMessageToMyQueue("coucou");
    }

    private void sendJMSMessageToMyQueue(String messageData) {
        context.createProducer().send(myQueue, messageData);
    }

    @Override
    public void sendMessageTopic(String message) {
        try {
            
            TextMessage tm = context.createTextMessage();
            tm.setText("Bonjour petit topic" + message);
            tm.setBooleanProperty("toMDB", true);
            context.createProducer().send(myTopic, tm);
            //producer.send(tm);

        } catch (JMSException ex) {
            Logger.getLogger(EJBAnalyses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
