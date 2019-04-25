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
        String number = request.getParameter("number");
        String numb = request.getParameter("reset");
        MultiplicationNumber multiplicationNumber = new MultiplicationNumber();
        int s[] = multiplicationNumber.divisionExpression(number);
        String k = String.valueOf(multiplicationNumber.multiplicationOfNumbers(s));

        if (k.length() > 4) {
            request.setAttribute("KEY", "Correct data");
            request.getRequestDispatcher("multi.jsp").forward(request, resp);
        }
        if (k.length() <= 1) {
            request.setAttribute("KEY", "Correct data");
            request.getRequestDispatcher("multi.jsp").forward(request, resp);
        }
        request.setAttribute("KEY", k);
        request.getRequestDispatcher("multi.jsp").forward(request, resp);
    }
}

