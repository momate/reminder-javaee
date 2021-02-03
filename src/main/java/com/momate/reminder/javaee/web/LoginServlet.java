package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.exception.UserNotFoundException;
import com.momate.reminder.javaee.service.UserService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1l;

    @Inject
    private UserService service;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");

        try {
            session.setAttribute("loggedUsername", username);
            session.setAttribute("loggedUserId", service.getUserByUsername(username).get().getId());
        } catch (UserNotFoundException ex) {
            request.setAttribute("NOTIFICATION", ex.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        response.sendRedirect("list");
    }

}
