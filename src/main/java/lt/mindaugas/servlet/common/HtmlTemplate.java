package lt.mindaugas.servlet.common;

public class HtmlTemplate {

    public static final String htmlStart =
            """
                    <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>%s</title>
                        </head>
                        <body>
                    """;

    public static final String htmlEnd =
            """
                    </body>
                    </html>
                    """;

    public static final String formUserDetails =
            """
                    <form action="%1$s" method="post">
                            <div>
                                <label for="userId">id: %2$s</label>
                                <input type="hidden" id="userId" name="userId" value="%2$s">
                                <br>
                            </div>
                            <div>
                                <label for="firstName">First name:</label><br>
                                <input type="text" id="firstName" name="firstName" value="%3$s">
                                <br>
                            </div>
                            <div>
                                <label for="lastName">Surname:</label><br>
                                <input type="text" id="lastName" name="lastName" value="%4$s">
                                <br>
                            </div>
                            <div>
                                <label for="email">Email:</label><br>
                                <input type="email" id="email" name="email" value="%5$s">
                                <br>
                            </div>
                            <div>
                                <label for="phone">Phone:</label><br>
                                <input type="text" id="phone" name="phone" value="%6$s">
                                <br>
                            </div>
                            <input type="submit" value="Submit">
                    </form>
                    """;
}
