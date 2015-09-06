package es.juandavidvega.seventeentrackmailer.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static es.juandavidvega.seventeentrackmailer.mail.MailConfig.*;

public class MailSender {

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
            message.setFrom(new InternetAddress(From.value()));
            message.addRecipient(Message.RecipientType.TO,
                                 new InternetAddress(to));
            message.setSubject(Subject.value());
            message.setText(messageBody);
            Transport.send(message);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }

    private Properties getMailProperties() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", Host.value());
        return properties;
    }


}
