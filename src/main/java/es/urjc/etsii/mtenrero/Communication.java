
package es.urjc.etsii.mtenrero;

import es.urjc.etsii.mtenrero.ServicioInterno.MailerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLSocketFactory;
import javax.xml.ws.Response;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by was12 on 15/03/2017.
 */
public class Communication {
    public  void main(String email,String subject,String body) throws UnknownHostException, IOException{
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("email", email);
        map.add("subject", subject);
        map.add("body", body);
        ResponseEntity<MailerResponse> response =  restTemplate.postForEntity("https://"+System.getenv("HAPROXY")+":8083/sendEmail",map,MailerResponse.class);

    }
}
