/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;

/**
 *
 * @author tibha
 */
@Stateless
public class EJBPatient implements EJBPatientRemote {

    @Override
    public String sayHello(String name) {
        return "Hello Patient" + name;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
