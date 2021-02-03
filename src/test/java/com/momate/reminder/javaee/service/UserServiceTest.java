package com.momate.reminder.javaee.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.momate.reminder.javaee.dao.UserDao;
import com.momate.reminder.javaee.exception.UserNotFoundException;
import com.momate.reminder.javaee.model.User;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    private UserDao userDao;
    @InjectMocks
    private UserService underTest;
    private User u;

    @BeforeEach
    void init() {
        underTest = new UserService();
        MockitoAnnotations.initMocks(this);
        u = new User();
        u.setUsername("username");
        u.setPassword("password123");
        u.setEmail("test@gmail.com");

    }

    @Test
    void testInit() {
        assertNotNull(underTest);
        assertNotNull(u);
        assertNotNull(userDao);
    }

    @Test
    public void testValidatePasswordWithWrongPass() {
        String wrongPsw = "asdf";

        assertFalse(underTest.validatePassword(wrongPsw));
    }

    @Test
    public void testValidatePasswordWithGoodPass() {
        String goodPsw = "asdf123";

        assertTrue(underTest.validatePassword(goodPsw));
    }

    @Test
    public void testDecrypt() {
        String testString = "asdf123";
        String encryptedString = underTest.encrypt(testString);

        assertEquals(underTest.decrypt(encryptedString), testString);
    }

    @Test
    public void testValidateEmailWithCorrectEmail() {
        when(userDao.findByEmail(u.getEmail()))
                .thenReturn(Optional.of(u));

        assertTrue(underTest.validateEmail(u.getEmail()));
    }

    @Test
    public void testValidateEmailWithIncorrectEmail() {
        String email = "wrongemail@gmail.com";
        when(userDao.findByEmail(email))
                .thenReturn(Optional.empty());

        assertFalse(underTest.validateEmail(email));
    }

    @Test
    public void testGetUserByUsernameWithValid() throws UserNotFoundException {
        when(userDao.findByUsername(u.getUsername()))
                .thenReturn(Optional.of(u));
        assertEquals(u, underTest.getUserByUsername(u.getUsername()).get());
    }

    @Test
    public void testGetUserByUsernameWithoutValid() {
        String username = "test";
        when(userDao.findByUsername(username))
                .thenReturn(Optional.empty());
        UserNotFoundException thrown = assertThrows(UserNotFoundException.class,
                () -> underTest.getUserByUsername(username));
        assertTrue(thrown.getMessage().contains("User"));

    }

    @Test
    public void testGetUserByUsernameWithNull() {
        String username = null;
        when(userDao.findByUsername(username))
                .thenReturn(Optional.empty());
        UserNotFoundException thrown = assertThrows(UserNotFoundException.class,
                () -> underTest.getUserByUsername(username));
        assertTrue(thrown.getMessage().contains("User"));
    }

    @Test
    public void testValidateLoginWithCorrectUsernameIncorrectPasswoerd() {
        String password = "";
        when(userDao.findByUsername(u.getUsername()))
                .thenReturn(Optional.of(u));

        assertFalse(underTest.validateLogin(u.getUsername(), password));
    }

    @Test
    public void testValidateLoginWithIncorrectUsernameCorrectPasswoerd() {
        String password = "wrong";
        String username = "wrong";
        when(userDao.findByUsername(username))
                .thenReturn(Optional.empty());

        assertFalse(underTest.validateLogin(username, password));
    }

    @Test
    public void testValidateLoginWithCorrectUsernameCorrectPasswoerd() {

        when(userDao.findByUsername(u.getUsername()))
                .thenReturn(Optional.of(u));

        assertFalse(underTest.validateLogin(u.getUsername(), u.getPassword()));
    }

}
