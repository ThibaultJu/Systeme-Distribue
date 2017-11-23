/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationmedecin;

import Patient.SessionBeanRemoteRemote;
import javax.ejb.EJB;

/**
 *
 * @author Vince
 */
public class Main {

    @EJB
    private static SessionBeanRemoteRemote sessionBeanRemote;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(sessionBeanRemote.sayHello("Jean-claude Van Damme"));
    }
    
}
