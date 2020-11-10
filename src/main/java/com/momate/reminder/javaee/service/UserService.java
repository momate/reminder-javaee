package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.dao.LoginAuthenticater;
import com.momate.reminder.javaee.dao.UserDao;
import com.momate.reminder.javaee.model.User;
import java.util.Optional;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class UserService implements LoginAuthenticater {

    @Inject
    private UserDao dao;

    @Override
    public boolean validate(String username, String password) {

        Optional<User> u = dao.findByUsername(username);

        return u.isPresent() && password.equals(u.get().getPassword());

    }

}
