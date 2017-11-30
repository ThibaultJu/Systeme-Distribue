/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remote;

import Patient.SessionBeanRemoteRemote;
import javax.ejb.Stateless;

/**
 *
 * @author Vince
 */
@Stateless
public class SessionBeanRemote implements SessionBeanRemoteRemote {

    @Override
    public String sayHello(String name) {
        return "Salut "+name;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
