package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.dao.LoginAuthenticater;
import com.momate.reminder.javaee.dao.UserDao;
import com.momate.reminder.javaee.model.User;
import java.util.Base64;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
@LocalBean
public class UserService implements LoginAuthenticater {

    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    @Inject
    private UserDao dao;

    @Override
    public boolean validateLogin(String username, String password) {

        Optional<User> u = dao.findByUsername(username);

        return u.isPresent()
                && password.equals(
                        decrypt(u.get().getPassword())
                );

    }

    public boolean validateUsername(String username) {
        return dao.findByUsername(username).isPresent();
    }

    public boolean validateEmail(String email) {
        return dao.findByEmail(email).isPresent();
    }

    public boolean validatePassword(String password) {
        return password.matches("^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,}$");
    }

    public void addUser(User user) {
        dao.save(user);
    }

    public User getUserByUsername(String username) {
        return dao.findByUsername(username).get();
    }

    public String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
