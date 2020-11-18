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

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private static final String SUCCES_MSG = "Successful registration!";

    @Inject
    private UserService service;

//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//
//        response.sendRedirect("register.jsp");
//    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        service.addUser(user);

        request.setAttribute("succes", SUCCES_MSG);

        request.getRequestDispatcher("register.jsp")
                .forward(request, response);

    }
}
