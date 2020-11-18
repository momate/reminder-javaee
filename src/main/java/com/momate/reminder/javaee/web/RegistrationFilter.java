package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.service.UserService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/register")
public class RegistrationFilter implements Filter {

    @Inject
    private UserService service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        boolean canChain = true;

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (service.validateUsername(username)) {
            canChain = false;
            String wUsername = "The username is taken, try another!";
            request.setAttribute("wrongUsername", wUsername);
        }

        if (service.validateEmail(email)) {
            canChain = false;
            String wEmail = "The email is already used!";
            request.setAttribute("wrongEmail", wEmail);
        }

        if (!service.validatePassword(password)) {
            canChain = false;
            String wPassword = "Password must contain at least one letter, at least one number, and be longer than six charaters!";
            request.setAttribute("wrongPassword", wPassword);
        }
        
        if (canChain) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("register.jsp")
                    .forward(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
