package lt.mindaugas.servlet.kids_calculator;

import lt.mindaugas.servlet.common.HtmlTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/calculator/palyginti")
public class PalygintiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(HtmlTemplate.htmlStart.apply("Calculator - palyginti"));
        writer.write(HtmlTemplate.htmlBackToMenu);
        writer.write(HtmlTemplate.htmlBackToCalculatorMenu);

        if (req.getParameter("numbers") != null) {

            String inputNumbers = req.getParameter("numbers");
            List<String> numbers = Arrays.asList(inputNumbers.split(","));

            String message = "";

            double result = 0;
            try {
                result = numbers.stream()
                        .mapToDouble(n -> Double.parseDouble(n.trim()))
                        .max()
                        .orElse(0);

            } catch (NumberFormatException e) {
                message = "<p style=\"color:red\">BLOGAI IVESTOS REIKSMES</p>";
            }

            writer.write(HtmlTemplate.getCompareTemplate(message, "palyginti", inputNumbers, result));

        } else {
            writer.write(HtmlTemplate.getCompareTemplate("", "palyginti", "", 0.0));
        }
        writer.write(HtmlTemplate.htmlEnd);
    }
}
