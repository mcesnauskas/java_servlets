package lt.mindaugas.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tikrink")
public class ServletHttpMethods extends HttpServlet {
    private String message = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        message = "GET was invoked";
        PrintWriter writer = resp.getWriter();
        writer.write(
                """
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>HTTP Methods Example</title>
                            <script src="https://unpkg.com/htmx.org@1.7.0"></script>
                        </head>
                        """
        );

        writer.write(
                """
                        <body>
                            <div>
                                 <a id="lifecycle" href="http://localhost:8072/java_servlets">
                                        Back to menu
                                 </a>
                            </div>
                        <div>
                            <div class="container">
                                <div id="content">
                                    <!-- Existing content to be replaced by HTMX -->
                                    <h1>%s</h1>
                                </div>
                                <form action="/java_servlets/tikrink" method="get">
                                    <button type="submit">GET</button>
                                </form>
                                <form action="/java_servlets/tikrink" method="post">
                                    <button type="submit">POST</button>
                                </form>
                                <div>
                                    <!-- Button to invoke PUT method -->
                                    <button hx-put="/java_servlets/tikrink" hx-target="#content" hx-swap="innerHTML">Invoke PUT Method</button>
                                </div>
                                <div>
                                    <!-- Button to invoke DELETE method -->
                                    <button hx-delete="/java_servlets/tikrink" hx-target="#content" hx-swap="innerHTML">Invoke DELETE Method</button>
                                </div>
                            </div>
                        </div>
                        </body>
                        </html>
                        """.formatted(message)
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        message = "POST was invoked";
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(
                """
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>HTTP Methods Example</title>
                            <script src="https://unpkg.com/htmx.org@1.7.0"></script>
                        </head>
                        """
        );

        writer.write(
                """
                        <body>
                            <div>
                                 <a id="lifecycle" href="http://localhost:8072/java_servlets">
                                        Back to menu
                                 </a>
                            </div>
                        <div>
                            <div class="container">
                                <div id="content">
                                    <!-- Existing content to be replaced by HTMX -->
                                    <h1>%s</h1>
                                </div>
                                <form action="/java_servlets/tikrink" method="get">
                                    <button type="submit">GET</button>
                                </form>
                                <form action="/java_servlets/tikrink" method="post">
                                    <button type="submit">POST</button>
                                </form>
                                <div>
                                    <!-- Button to invoke PUT method -->
                                    <button hx-put="/java_servlets/tikrink" hx-target="#content" hx-swap="innerHTML">Invoke PUT Method</button>
                                </div>
                                <div>
                                    <!-- Button to invoke DELETE method -->
                                    <button hx-delete="/java_servlets/tikrink" hx-target="#content" hx-swap="innerHTML">Invoke DELETE Method</button>
                                </div>
                            </div>
                        </div>
                        </body>
                        </html>
                        """.formatted(message)
        );
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>PUT was invoked</h1>");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>DELETE was invoked</h1>");
    }
}
