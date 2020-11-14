
package com.momate.reminder.javaee.web;

import com.momate.reminder.javaee.dao.ReminderDao;
import com.momate.reminder.javaee.model.Reminder;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class ReminderDeleteServlet extends HttpServlet{
    
    @Inject
    private ReminderDao dao;
    
     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
   
        Long id = Long.parseLong(request.getParameter("reminderId").toString());
        Reminder reminder = dao.findById(id).get();
        
        dao.delete(reminder);

        response.sendRedirect("list");

    }

    
}
