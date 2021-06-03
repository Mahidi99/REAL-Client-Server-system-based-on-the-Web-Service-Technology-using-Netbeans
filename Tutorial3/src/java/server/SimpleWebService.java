/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * 
 * @author Acer
 */
@WebService(serviceName = "SimpleWebService")
public class SimpleWebService {

    private static final String serverName = "Server";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date(); 
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        InetAddress ip;
        String hostname;
        String hostAddress;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            hostAddress = ip.getHostAddress();
            System.out.println("[SERVER] - Current IP address : " + ip);
            System.out.println("[SERVER] - Hostname and address: " + hostname + "/" + hostAddress);
 
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
        
        return "["+date+"]"+"["+ serverName +"]"+" Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isConnected")
    public Boolean isConnected() {
        System.out.println("["+date+"] "+"[SERVER] - Testing if the Server is connected");
        return true;
    }
}