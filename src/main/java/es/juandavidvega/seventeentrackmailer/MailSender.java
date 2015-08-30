package es.juandavidvega.seventeentrackmailer;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    public static final String host = "127.0.0.1";
    private final static String from = "root@juandavidvega.es";
    private static final String Subject = "Package tracking information";

    private final String to;
    private final String messageBody;

    public MailSender(String to, String messageBody){
        this.to = to;
        this.messageBody = messageBody;
    }

    public void send(){

        Session session = Session.getDefaultInstance(getMailProperties());
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                                 new InternetAddress(to));
            message.setSubject(Subject);
            message.setText(messageBody);
            Transport.send(message);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }

    private Properties getMailProperties() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        return properties;
    }


}
