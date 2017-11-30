/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author tibha
 */
@WebService(serviceName = "WSRESULTAT")
@Stateless()
public class WSRESULTAT {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name = "name") String name) {
        return"Hello "+name;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "coucou")
    public String coucou(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "cac") String cac) {
        //TODO write your implementation code here:
        return null;
    }
}
