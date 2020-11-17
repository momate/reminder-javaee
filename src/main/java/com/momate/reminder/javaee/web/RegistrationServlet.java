package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.model.User;
import com.momate.reminder.javaee.service.UserService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    @Inject
    private UserService service;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.sendRedirect("register.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        boolean canSave = true;

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (service.validateUsername(username)) {
            String wUsername = "The username is taken, try another!";
            canSave = false;
            request.setAttribute("wrongUsername", wUsername);
        }

        if (service.validateEmail(email)) {
            String wEmail = "The email is already used!";
            canSave = false;
            request.setAttribute("wrongEmail", wEmail);
        }

        if (!service.validatePassword(password)) {
            String wPassword = "Password must contain at least one letter, at least one number, and be longer than six charaters!";
            canSave = false;
            request.setAttribute("wrongPassword", wPassword);
        }

        if (canSave) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);

            service.addUser(user);

            String succes = "Successful registration!";
            request.setAttribute("succes", succes);
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);

    }
}
