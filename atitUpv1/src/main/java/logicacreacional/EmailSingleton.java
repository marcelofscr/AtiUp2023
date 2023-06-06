package logicacreacional;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import logicadenegocios.Email;

public class EmailSingleton {
    private static Email instance;

    private EmailSingleton() {
        // Private constructor 
    }

    public static synchronized Email getInstance() {
        if (instance == null) {
            instance = new Email();
        }
        return instance;
    }

    
}
