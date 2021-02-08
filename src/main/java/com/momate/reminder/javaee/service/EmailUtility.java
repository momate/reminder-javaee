package com.momate.reminder.javaee.service;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import java.security.InvalidParameterException;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@LocalBean
public class EmailUtility {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtility.class);

    private MailjetClient client;
    private MailjetRequest request;

    public void send(JSONObject email) {
        try {
            request = initRequest(email);
            client.post(request);
        } catch (MailjetException | MailjetSocketTimeoutException ex) {
            LOGGER.error("Error occurred during email sending: " + ex.getMessage());
        }

    }

    public JSONObject constructMessage(String emailFrom, String nameFrom, String emailTo, String nameTo, String subject, String text) {
        JSONObject email = new JSONObject();

        email.put(Emailv31.Message.FROM, new JSONObject()
                .put("Email", emailFrom)
                .put("Name", nameFrom));

        email.put(Emailv31.Message.TO, new JSONArray()
                .put(new JSONObject()
                        .put("Email", emailTo)
                        .put("Name", nameTo)))
                .put(Emailv31.Message.SUBJECT, subject)
                .put(Emailv31.Message.HTMLPART, text)
                .put(Emailv31.Message.CUSTOMID, UUID.randomUUID());

        return email;
    }

    @PostConstruct
    private void initClient() {
        String apiKey = System.getenv("MAILJET_API_KEY");
        String secretKey = System.getenv("MAILJET_SECRET_KEY");

        if (apiKey.isEmpty()) {
            throw new InvalidParameterException("ApiKey not found");
        } else {
            client = new MailjetClient(apiKey, secretKey,
                    new ClientOptions("v3.1"));
        }
    }

    private MailjetRequest initRequest(JSONObject email) {
         request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray().put(email));
        return request;
    }

}
