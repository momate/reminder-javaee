package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.model.Reminder;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@LocalBean
@Stateless
public class EmailScheduler {

    @Inject
    private ReminderEmailNotification emailNotification;
    private Timer time = new Timer();

    public void setSchedule(Reminder reminder) {
        emailNotification.setReminder(reminder);
        Duration duration = Duration.between(LocalDateTime.now(), reminder.getTargetDate());

        time.schedule(emailNotification, duration.toMillis());
    }

}
