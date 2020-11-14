package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.dao.ReminderDao;
import com.momate.reminder.javaee.model.Reminder;
import java.io.IOException;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class ReminderEditServlet extends HttpServlet {

    @Inject
    private ReminderDao dao;

    private Long id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        id = Long.parseLong(request.getParameter("reminderId").toString());
        Reminder reminderUpdate = dao.findById(id).get();

        request.setAttribute("reminder", reminderUpdate);
        request.getRequestDispatcher("reminder-edit.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Reminder reminderUpdate = dao.findById(id).get();
        reminderUpdate.setTitle(request.getParameter("title"));
        reminderUpdate.setDescription(request.getParameter("description"));
        reminderUpdate.setTargetDate(LocalDate.parse(
                request.getParameter("date")));

        dao.update(reminderUpdate);

        response.sendRedirect("list");

    }

}
