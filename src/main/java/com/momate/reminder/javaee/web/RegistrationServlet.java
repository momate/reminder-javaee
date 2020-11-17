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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (service.validate(username)) {
            String wUsername = "The username is taken, try another!";
            request.setAttribute("wrongUsername", wUsername);
        }
        
        if(service.validate(email)){
            String wEmail = "The email is already used!";
            request.setAttribute("wrongEmail", wEmail);
        }

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);

        service.addUser(user);
        
        String succes = "Successful registration!";
        request.setAttribute("succes", succes);
        request.getRequestDispatcher("register.jsp").forward(request, response);

    }
}
