package org.jazzteam;
import multiplication.MultiplicationNumber;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class NumberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        MultiplicationNumber multiplicationNumber = new MultiplicationNumber();

        String description = request.getParameter("description");
        resp.getWriter().println("description=" + description);
        String number = request.getParameter("number");
        int s[] = multiplicationNumber.divisionExpression(number);
        String k = String.valueOf(multiplicationNumber.multiplicationOfNumbers(s));

        request.setAttribute("KEY", k);
        request.getRequestDispatcher("multi.jsp").forward(request, resp);
    }
}

