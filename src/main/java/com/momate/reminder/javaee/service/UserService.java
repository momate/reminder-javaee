package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.dao.LoginAuthenticater;
import com.momate.reminder.javaee.dao.UserDao;
import com.momate.reminder.javaee.model.User;
import java.util.Optional;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
@LocalBean
public class UserService implements LoginAuthenticater {

    @Inject
    private UserDao dao;

    @Override
    public boolean validate(String username, String password) {

        Optional<User> u = dao.findByUsername(username);

        return u.isPresent() && password.equals(u.get().getPassword());

    }

    public boolean validate(String username) {

        return dao.findByUsername(username).isPresent();

    }

    public void addUser(User user) {
        dao.save(user);
    }

    public User getUserByUsername(String username) {
        return dao.findByUsername(username).get();
    }

}
