package es.urjc.etsii.mtenrero.ServicioInterno;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Adrian on 4/5/17.
 */
public class MailerResponse {
    boolean ok;
    String message;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MailerResponse() {}

    @Autowired
    public MailerResponse(boolean ok, String message) {
        this.ok = ok;
        this.message = message;
    }
}