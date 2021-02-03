package com.momate.reminder.javaee.service;

import com.momate.reminder.javaee.dao.LoginAuthenticater;
import com.momate.reminder.javaee.dao.UserDao;
import com.momate.reminder.javaee.exception.UserNotFoundException;
import com.momate.reminder.javaee.model.User;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
@LocalBean
public class UserService implements LoginAuthenticater {

    private static final String KEY = "aesEncryptionKey";
    private static final String INIT_VECTOR = "encryptionIntVec";

    private UserDao dao;

    @Inject
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public UserService() {
    }

    @Override
    public boolean validateLogin(String username, String password) {

        Optional<User> u;
        try {
            u = this.getUserByUsername(username);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

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

    public Optional<User> getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> usr = dao.findByUsername(username);
        if (usr.isPresent()) {
            return usr;
        } else {
            throw new UserNotFoundException("User not found by username: " + username);
        }
    }
    
    //TODO: refactor the encryption and decryption methods

    public String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
            
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | 
                InvalidKeyException | NoSuchAlgorithmException | BadPaddingException |
                IllegalBlockSizeException | NoSuchPaddingException ex) {
            System.out.println("");
        }
        return " ";
    }

    public String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException |
                InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | 
                IllegalBlockSizeException | NoSuchPaddingException ex) {
        }

        return " ";
    }

}
