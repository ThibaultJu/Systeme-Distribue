/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;


import entities.*;
import javax.ejb.Remote;

/**
 *
 * @author tibha
 */
@Remote
public interface EJBPatientRemote {

    String sayHello(String name);
    Patient getPatient(int id);

    Boolean CheckIdMedecin();
}
