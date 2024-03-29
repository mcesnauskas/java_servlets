package lt.mindaugas.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/lifecycle")
public class ServletLifecycle extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("*** INIT ***" + LocalDateTime.now() + " ***");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("*** SERVICE ***" + LocalDateTime.now() + " ***");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("*** DESTROY ***" + LocalDateTime.now() + " ***");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("*** HTTP METHOD GET ***" + LocalDateTime.now() + " ***");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
//        writer.write("HTTP GET method in action:");
//        writer.write("Penktadienis" + LocalDateTime.now());
//        writer.write("Penktadienis" + LocalDateTime.now());
//        writer.println("Penktadienis" + LocalDateTime.now());
//        writer.println("Penktadienis" + LocalDateTime.now());

        writer.println(
                """
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                           <meta charset="UTF-8">
                           <meta name="viewport" content="width=device-width, initial-scale=1.0">
                           <title>Lifecycle</title>
                        </head>
                        <body>
                        """
        );

        for (int i = 1; i < 6; i++) {
            writer.println(
                    """
                            <div class="container" >
                                <h%1$d > Servlet lifecycle </h%1$d >
                            </div >
                            """.formatted(i)
            );
        }

        writer.println(
                """
                        </body >
                        </html >
                        """
        );
    }
}
