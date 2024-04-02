package lt.mindaugas.servlet.kids_calculator;

import lt.mindaugas.servlet.common.HtmlTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator/skaiciuok")
public class SkaiciuokServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(HtmlTemplate.htmlStart.apply("Calculator"));
        writer.write(HtmlTemplate.htmlBackToMenu);
        writer.write(HtmlTemplate.htmlBackToCalculatorMenu);
        writer.write("<br>");

        if (req.getParameter("calculate") != null) {

            String input = req.getParameter("calculate").trim();
            String message = "";
            double a;
            double b;

            double result = 0.0;

            try {
                if (input.contains("*")) {
                    a = Double.parseDouble(input.substring(0, input.indexOf('*')).trim());
                    b = Double.parseDouble(input.substring(input.indexOf('*') + 1).trim());
                    result = a * b;
                } else if (input.contains("+")) {
                    a = Double.parseDouble(input.substring(0, input.indexOf('+')).trim());
                    b = Double.parseDouble(input.substring(input.indexOf('+') + 1).trim());
                    result = a + b;
                } else if (input.contains("-")) {
                    a = Double.parseDouble(input.substring(0, input.indexOf('-')).trim());
                    b = Double.parseDouble(input.substring(input.indexOf('-') + 1).trim());
                    result = a - b;
                } else if (input.contains("/")) {
                    a = Double.parseDouble(input.substring(0, input.indexOf('/')).trim());
                    b = Double.parseDouble(input.substring(input.indexOf('/') + 1).trim());
                    result = a / b;
                }
            } catch (NumberFormatException e) {
                message = """
                        <div>
                            <p style=\"color:red\">BLOGAI IVESTOS REIKSMES</p>
                        </div>
                        """;
            }

            writer.write(HtmlTemplate.getCalculate(message, "skaiciuok", input, result));
        } else {
            writer.write(HtmlTemplate.getCalculate("", "skaiciuok", "", 0.0));
        }
        writer.write(HtmlTemplate.htmlEnd);
    }
}
