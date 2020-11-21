package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.dao.ReminderDao;
import com.momate.reminder.javaee.model.Reminder;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ReminderFetchServlet extends HttpServlet {

    @Inject
    private ReminderDao dao;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Long userId = Long.parseLong(
                request.getSession()
                        .getAttribute("loggedUserId")
                        .toString());

        List<Reminder> reminders = dao.findByUserId(userId);
        
        request.setAttribute("reminders", reminders);
        request.getRequestDispatcher("reminder-list.jsp").forward(request, response);
    }

}
