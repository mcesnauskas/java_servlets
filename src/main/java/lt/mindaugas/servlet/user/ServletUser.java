package lt.mindaugas.servlet.user;

import lt.mindaugas.servlet.common.HtmlTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/detail")
public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        User user;

        if (req.getParameter("firstName") != null){

            user = new User(
                    Math.incrementExact(Integer.parseInt(req.getParameter("userId"))),
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    req.getParameter("email"),
                    req.getParameter("phone")
            );
        } else {
            user = new User(0, "", "", "", "");
        }

        writer.write(HtmlTemplate.htmlStart.formatted("User Details"));
        writer.write(
                HtmlTemplate.formUserDetails.formatted(
                        "/java_servlets/users/detail",
                        user.id(),
                        user.firstName(),
                        user.lastName(),
                        user.email(),
                        user.phone()
                )
        );
        writer.write(HtmlTemplate.htmlEnd);
    }


}
