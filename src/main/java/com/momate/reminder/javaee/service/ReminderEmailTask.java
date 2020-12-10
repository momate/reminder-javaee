package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.model.Reminder;
import java.util.TimerTask;
import javax.inject.Inject;

public class ReminderEmailTask extends TimerTask {

    private Reminder reminder;
    private EmailUtility email;

    @Inject
    public ReminderEmailTask(EmailUtility email, Reminder reminder) {
        this.email = email;
        this.reminder = reminder;
    }

    @Override
    public void run() {
        email.send(reminder);

    }

}
