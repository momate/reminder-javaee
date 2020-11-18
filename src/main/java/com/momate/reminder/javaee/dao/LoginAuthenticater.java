
package com.momate.reminder.javaee.dao;

public interface LoginAuthenticater {
    
    boolean validateLogin(String username, String password);
    
}
