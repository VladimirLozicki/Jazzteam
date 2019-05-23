package org.jazzteam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {

        //Singleton singleton = Singleton.getInstance();
        String number = request.getParameter("number");
        String action = request.getParameter("action");
        resp.setContentType("text/plain");
        resp.getWriter().write(number);
    }
}

