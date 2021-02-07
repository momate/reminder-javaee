package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.model.Reminder;
import com.momate.reminder.javaee.model.User;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.json.JSONObject;

@LocalBean
@Singleton
public class EmailService {

    @Inject
    private Scheduler scheduler;
    @Inject
    private EmailUtility emailUtility;

    private static final String EMAIL_FROM = "momate150@gmail.com";
    private static final String NAME_FORM = "Máté Molnár";
    private static final String SUBJECT = "Reminder";


    public JSONObject constructMessage(Reminder reminder) {
        User user = reminder.getUser();
        JSONObject email = emailUtility.constructMessage(EMAIL_FROM, NAME_FORM,
                user.getEmail(), user.getFirstName(),
                SUBJECT,
                emailText(user.getLastName(),
                        reminder.getTitle(),
                        reminder.getDescription()));
        return email;
    }

    public void setSchedule(Reminder reminder) {
        ReminderEmailTask task = new ReminderEmailTask(emailUtility,constructMessage(reminder));
        Duration time = Duration.between(LocalDateTime.now(),
                reminder.getTargetDate());

        scheduler.setSchedule(task, time.toMillis());
    }

    private String emailText(String name, String title, String descrition) {
        String text = "<h2>Dear " + name + ", you have a reminder!</h2><br/> "
                + "<h3>" + title + "</h3><br/>"
                + descrition;

        return text;
    }

}
