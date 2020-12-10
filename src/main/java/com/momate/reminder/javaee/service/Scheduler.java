package com.momate.reminder.javaee.service;

import java.util.Timer;
import java.util.TimerTask;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class Scheduler {

    private final Timer timer = new Timer();

    public <T extends TimerTask> void setSchedule(T task, Long time) {
        timer.schedule(task, time);
    }
    

}
