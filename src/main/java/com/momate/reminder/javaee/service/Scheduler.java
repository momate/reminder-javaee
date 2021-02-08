package com.momate.reminder.javaee.service;

import java.util.Timer;
import java.util.TimerTask;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@LocalBean
@Singleton
public class Scheduler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtility.class);
    
    private final Timer timer = new Timer();
    
    public <T extends TimerTask> void setSchedule(T task, Long time) {
        try {
            timer.schedule(task, time);
        } catch (NullPointerException ex) {
            LOGGER.error("Some properties are missing during the scheduling" + ex.getMessage());
        }
        
    }
    
}
