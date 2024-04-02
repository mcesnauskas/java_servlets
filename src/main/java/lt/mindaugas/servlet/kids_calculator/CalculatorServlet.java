package lt.mindaugas.servlet.kids_calculator;

import lt.mindaugas.servlet.common.HtmlTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(HtmlTemplate.htmlStart.apply("Calculator - sudeti"));
        writer.write(HtmlTemplate.htmlBackToMenu);
        writer.write(HtmlTemplate.htmlCalculatorMenu);
        writer.write(HtmlTemplate.htmlEnd);
    }
}
