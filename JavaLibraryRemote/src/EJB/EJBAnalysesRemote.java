/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entities.Analyses;
import javax.ejb.Remote;
import javax.jms.Session;

/**
 *
 * @author tibha
 */
@Remote
public interface EJBAnalysesRemote {

    String sayHello(String name);

    void sendMessageQueue();

    void sendMessageTopic(String message);
    
    Analyses getAnalyses(int id);
}
