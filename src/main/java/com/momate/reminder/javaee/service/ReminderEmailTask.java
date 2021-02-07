package com.momate.reminder.javaee.service;

import java.util.TimerTask;
import org.json.JSONObject;

public class ReminderEmailTask extends TimerTask {

    private final EmailUtility emailUtility;
    private JSONObject email;

    public ReminderEmailTask(EmailUtility emailUtility, JSONObject email) {
        this.emailUtility = emailUtility;
        this.email = email;
    }

    @Override
    public void run() {
        emailUtility.send(email);

    }

}
