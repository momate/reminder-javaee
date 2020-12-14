package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.model.Reminder;
import java.util.TimerTask;
import javax.inject.Inject;

public class ReminderEmailTask extends TimerTask {

    private EmailUtility email;
    private Reminder reminder;
    private String subject;
    private String text;

    @Inject
    public ReminderEmailTask(EmailUtility email, Reminder reminder) {
        this.email = email;
        this.reminder = reminder;
    }

    public ReminderEmailTask(EmailUtility email, Reminder reminder, String subject, String text) {
        this.email = email;
        this.reminder = reminder;
        this.subject = subject;
        this.text = text;
    }

    @Override
    public void run() {
        email.send(reminder.getUser().getEmail(), subject, text);

    }

}
