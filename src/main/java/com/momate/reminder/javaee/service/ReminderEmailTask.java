package com.momate.reminder.javaee.service;

import java.util.TimerTask;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReminderEmailTask extends TimerTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReminderEmailTask.class);

    private final EmailUtility emailUtility;
    private JSONObject email;

    public ReminderEmailTask(EmailUtility emailUtility, JSONObject email) {
        this.emailUtility = emailUtility;
        this.email = email;
    }

    @Override
    public void run() {
        try {
            emailUtility.send(email);
        } catch (Exception ex) {
            LOGGER.error("Error occured when tried to execute task: " + ex.getMessage());
        }

    }

}
