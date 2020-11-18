package com.momate.reminder.javaee.web;

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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String notification = "Wrong username or password!" ;
           request.setAttribute("NOTIFICATION", notification);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if (service.validateLogin(username, password)) {
            
            session.setAttribute("loggedUserId", service.getUserByUsername(username).getId());
            session.setAttribute("loggedUsername", username);

            response.sendRedirect("list");
        } else {
  
           response.sendRedirect("login");
        }

    }

}
