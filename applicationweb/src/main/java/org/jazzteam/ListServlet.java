package org.jazzteam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.jazzteam.singleton.*;

public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        Singleton singleton = Singleton.getInstance();
        String value = request.getParameter("value");
        String action = request.getParameter("action");
        switch (action) {
            case "addFront":
                singleton.addFront(value);
                break;
            case "DELETE":
                singleton.deleteElement(value);
                break;
            case "addBack":
                singleton.addBack(value);
                break;
        }
        request.setAttribute("VALUE", singleton.List());
        request.getRequestDispatcher("list.jsp").forward(request, resp);
    }
}

