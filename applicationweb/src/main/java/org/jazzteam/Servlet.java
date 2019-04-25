package org.jazzteam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

            String username = request.getParameter("login");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("admin")) {
                resp.sendRedirect("/ok.jsp");
            } else {

                request.getRequestDispatcher("/error.jsp").forward(request, resp);
            }
    }
}
