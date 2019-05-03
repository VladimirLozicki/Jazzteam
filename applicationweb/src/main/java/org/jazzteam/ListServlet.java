package org.jazzteam;

import org.jazzteam.singleton.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        Singleton singleton = Singleton.getInstance();
        String value = request.getParameter("value");
        String action = request.getParameter("action");
        if(value.isEmpty()){
            request.setAttribute("VALUE", singleton.List());
            request.getRequestDispatcher("list.jsp").forward(request, resp);
        }

        if(!value.isEmpty() && !action.isEmpty()) {
            switch (action) {
                case "addFront":
                    singleton.addFront(value);
                    request.setAttribute("VALUE", singleton.List());
                    request.getRequestDispatcher("list.jsp").forward(request, resp);
                    break;
                case "addBack":
                    singleton.addBack(value);
                    request.setAttribute("VALUE", singleton.List());
                    request.getRequestDispatcher("list.jsp").forward(request, resp);
                    break;
            }
        }
        else{
            request.getRequestDispatcher("list.jsp").forward(request, resp);
        }

    }
}

