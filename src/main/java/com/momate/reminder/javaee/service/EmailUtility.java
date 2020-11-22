package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.model.Reminder;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Singleton
@LocalBean
public class EmailUtility {

    private static final String EMAILPROPERTIES = "config.properties";
    private static String EMAIL = "";
    private static String PSW = "";

    @PostConstruct
    public void init() {
        try {
            Properties prop = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(EMAILPROPERTIES);

            if (inputStream != null) {
                prop.load(inputStream);
                EMAIL = prop.getProperty("email");
                PSW = prop.getProperty("password");
            } else {
                throw new FileNotFoundException("property file '" + EMAILPROPERTIES + "' not found in the classpath");
            }
        } catch (Exception e) {
        }
    }

    public void send(Reminder reminder) {
        String recipientAddress = reminder.getUser().getEmail();
        try {
            Transport.send(constructMessage(authentication(), recipientAddress, reminder));
        } catch (MessagingException ex) {
            Logger.getLogger(EmailUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Message constructMessage(Session session, String recipientAddress, Reminder reminder) throws MessagingException {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipientAddress));
        message.setSubject("REMINDER");
        message.setText("Dear " + reminder.getUser().getFirstName() + ","
                + "\n\n"
                + reminder.getTitle()
                + "\n"
                + reminder.getDescription());

        return message;

    }

    private Properties getInicializedProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return props;
    }

    private Session authentication() {
        Session session = Session.getInstance(getInicializedProperties(),
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PSW);
            }
        });

        return session;
    }

}
