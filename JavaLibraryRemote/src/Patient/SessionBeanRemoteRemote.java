/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import javax.ejb.Remote;

/**
 *
 * @author Vince
 */
@Remote
public interface SessionBeanRemoteRemote {

    String sayHello(String name);
    
}
