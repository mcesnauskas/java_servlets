package lt.mindaugas.servlet.kids_calculator;

import lt.mindaugas.servlet.common.HtmlTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator/padauginti")
public class PadaugintiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(HtmlTemplate.htmlStart.apply("Calculator - padauginti"));
        writer.write(HtmlTemplate.htmlBackToMenu);
        writer.write(HtmlTemplate.htmlBackToCalculatorMenu);

        if (req.getParameter("a") != null && req.getParameter("b") != null) {

            String a = req.getParameter("a").trim();
            String b = req.getParameter("b").trim();
            String message = "";

            double suma = 0;

            try {
                suma = Double.parseDouble(a) * Double.parseDouble(b);
            } catch (NumberFormatException e) {
                message = "<p style=\"color:red\">BLOGAI IVESTOS REIKSMES</p>";
            }

            writer.write(HtmlTemplate.getArithmeticTemplate(message, "padauginti", a, b, suma));
        } else {
            writer.write(HtmlTemplate.getArithmeticTemplate("", "padauginti", "", "", 0.0));
        }
        writer.write(HtmlTemplate.htmlEnd);
    }
}
