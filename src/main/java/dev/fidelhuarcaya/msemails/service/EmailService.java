package dev.fidelhuarcaya.msemails.service;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Properties;


@Service
public class EmailService {

    @Value("${email}")
    private String senderEmail; //your gmail email id
    @Value("${password}")
    private String senderPassword ;// your gmail id password
    public Mono<Boolean> sendEmail(String subject, String message, String to) {


        // Properties class enables us to connect to the host SMTP server
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.port", "587");

        propiedades.put("mail.properties.mail.smtp.connectiontimeout", "5000");
        propiedades.put("mail.properties.mail.smtp.timeout", "5000");
        propiedades.put("mail.properties.mail.smtp.writetimeout", "5000");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.starttls.required", "true");
        propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(propiedades, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); // Create a default MimeMessage object for compose the message

            msg.setFrom(new InternetAddress(senderEmail)); // adding sender email id to msg object

            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("fidelhuarcaya20@gmail.com")); // adding recipient to msg object

            msg.setSubject(subject); // adding subject to msg object
            msg.setText(message); // adding text to msg object

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email Sent Wtih Attachment Successfully...");

            return Mono.just(true); // Set the "foo" variable to true after successfully sending emails

        } catch (Exception e) {

            System.out.println("EmailService File Error" + e);
        }

        return Mono.just(false);  // and return foo variable
    }
}
