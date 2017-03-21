
package es.urjc.etsii.mtenrero;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by was12 on 15/03/2017.
 */
public class Comunication {

    public  void main(Object email,Object subject,Object body) {
//        System.setProperty("javax.net.ssl.trustStore","za.store");
//        Socket socket=((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost",4444);
//        OutputStream os = socket.getOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(os);
//        oos.writeObject(email);
//        oos.writeObject(subject);
//        oos.writeObject(body);
//        oos.close();
    }

    public void send(Object email,Object subject,Object body) throws UnknownHostException, IOException {
        System.setProperty("javax.net.ssl.trustStore", "za.store");
        Socket socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost", 4444);
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(email);
        oos.writeObject(subject);
        oos.writeObject(body);
        oos.close();
    }
}
