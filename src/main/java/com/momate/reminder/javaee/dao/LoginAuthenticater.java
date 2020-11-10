
package com.momate.reminder.javaee.dao;

public interface LoginAuthenticater {
    
    boolean validate(String username, String password);
    
}
