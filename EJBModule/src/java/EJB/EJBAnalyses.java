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
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author tibha
 */
@Stateless
public class EJBAnalyses implements EJBAnalysesRemote {

    @Resource(mappedName = "jms/myQueue")
    private Queue myQueue;
    @Resource(mappedName = "jms/myQueueFactory")
    private static ConnectionFactory myQueueFactory;
    
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Override
    public String sayHello(String name) {
        return"Hello analyse" + name;
    }
    private static Connection connection = null;
    private static Session session = null;
    
    public static void main(String[] args)
    {
        try
        {
            connection = myQueueFactory.createConnection();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            connection.start();
        } catch (JMSException ex) {
            Logger.getLogger(EJBAnalyses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendJMSMessageToMyQueue(String messageData) {
        context.createProducer().send(myQueue, messageData);
    }
}
