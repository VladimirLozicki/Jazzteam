package org.jazzteam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
//        Singleton singleton = Singleton.getInstance();
//        String value = request.getParameter("value");
//        String action = request.getParameter("action");
//            if(value.isEmpty()){
//            request.setAttribute("VALUE", singleton.List());
//        }
//       // PrintWriter printWriter = resp.getWriter();
//        if(!value.isEmpty() && !action.isEmpty()) {
//            switch (action) {
//                case "addFront":
//                    request.setAttribute("VALUE", singleton.List());
//                    singleton.addFront(value);
//                 //   printWriter.println(singleton.List());
//                    break;
//                case "addBack":
//                    singleton.addBack(value);
//                    request.setAttribute("VALUE", singleton.List());
//                    //printWriter.println(singleton.List());
//                    break;
//            }
       // }


            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            System.out.println(request.getParameter("email"));
        }
    }


