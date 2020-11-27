package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.service.UserService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/login")
public class LoginFilter implements Filter {

    @Inject
    private UserService service;

    private final String NOTIFICATION = "Wrong username or password!";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (service.validateLogin(username, password)) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("NOTIFICATION", NOTIFICATION);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
