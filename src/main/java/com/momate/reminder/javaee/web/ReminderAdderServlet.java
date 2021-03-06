package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.dao.ReminderDao;
import com.momate.reminder.javaee.dao.UserDao;
import com.momate.reminder.javaee.model.Reminder;
import com.momate.reminder.javaee.service.EmailService;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class ReminderAdderServlet extends HttpServlet {

    @Inject
    private ReminderDao reminderDao;

    @Inject
    private UserDao userDao;

    @Inject
    private EmailService emailService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("reminder-add.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Reminder reminder = new Reminder();
        Long userId = Long.parseLong(request
                .getSession()
                .getAttribute("loggedUserId")
                .toString());

        reminder.setTitle(request.getParameter("title"));
        reminder.setDescription(request.getParameter("description"));
        reminder.setTargetDate(LocalDateTime
                .parse(request.getParameter("date")));
        reminder.setUser(userDao.findById(userId).get());
        reminder.setStatus(true);

       emailService.setSchedule(reminder);

        reminderDao.save(reminder);

        response.sendRedirect("list");

    }
}
