package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.model.Reminder;
import java.util.TimerTask;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class ReminderEmailNotification extends TimerTask {

    
    @Inject
    private EmailUtility utility;

    private Reminder reminder;

    @Override
    public void run() {
        utility.send(this.reminder);
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
    
}
