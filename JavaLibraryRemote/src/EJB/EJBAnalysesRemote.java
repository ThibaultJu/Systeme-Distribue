/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entities.Analyses;
import entities.Demande;
import java.util.Vector;
import javax.ejb.Remote;

/**
 *
 * @author tibha
 */
@Remote
public interface EJBAnalysesRemote {

    String sayHello(String name);

    void sendMessageQueue(String message);

    void sendMessageTopic(String message,boolean MDB);
    
    Analyses getAnalyses(int id);

    int AddAnalyse(Demande analyse);

    Void AddAnalyse(Analyses analyse);

    Vector getAnalyses();
}
