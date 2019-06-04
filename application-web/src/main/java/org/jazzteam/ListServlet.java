package org.jazzteam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {

        String number = request.getParameter("number");
        String action = request.getParameter("action");
        resp.setContentType("text/plain");
        try{
            resp.getWriter().write(number);
        }catch (Exception exception){
            exception.getMessage();
        }

    }
}

