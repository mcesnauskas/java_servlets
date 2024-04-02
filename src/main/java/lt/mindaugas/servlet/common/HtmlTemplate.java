package lt.mindaugas.servlet.common;

import java.util.List;
import java.util.function.Function;

public class HtmlTemplate {

    public static Function<String, String> htmlStart =
            (message) -> {
                return """
                        <!DOCTYPE html>
                            <html lang="en">
                            <head>
                                <meta charset="UTF-8">
                                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                <title>%s</title>
                            </head>
                            <body>
                        """.formatted(message);
            };

    public static final String htmlEnd =
            """
                    </body>
                    </html>
                    """;

    public static final String htmlBackToMenu =
            """
                    <div class="container">
                        <a id="calculator" href="http://localhost:8072/java_servlets">back to Menu</a>
                    </div>
                    """;

    public static final String htmlBackToCalculatorMenu =
            """
                    <div class="container">
                        <a id="calculator" href="http://localhost:8072/java_servlets/calculator">back to Calculator Menu</a>
                    </div>
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

    public static String htmlCalculatorMenu =
            """
                    <div>
                        <br>
                        <div class="container">
                            <a id="sudeti" href="http://localhost:8072/java_servlets/calculator/sudeti">Sudeti</a>
                        </div>
                        <div class="container">
                            <a id="atimti" href="http://localhost:8072/java_servlets/calculator/atimti">Atimti</a>
                        </div>
                        <div class="container">
                            <a id="padauginti" href="http://localhost:8072/java_servlets/calculator/padauginti">Padauginti</a>
                        </div>
                        <div class="container">
                            <a id="padalinti"href="http://localhost:8072/java_servlets/calculator/padalinti">Padalinti</a>
                        </div>
                        <div class="container">
                            <a id="palyginti" href="http://localhost:8072/java_servlets/calculator/palyginti">Palygink skaicius</a>
                        </div>
                        <div class="container">
                            <a id="palyginti" href="http://localhost:8072/java_servlets/calculator/skaiciuok">Skaiciuok</a>
                        </div>
                    </div>
                    """;

    public static String getArithmeticTemplate(String message, String veiksmas, String a, String b, double suma) {
        return """
        <div>
                <div class="container">
                    %1$s
                    <form action="/java_servlets/calculator/%2$s" method="get">
                        <label for="a">Pirmas skaicius</label>
                        <input type="text" id="a" name="a" value="%3$s">
                        <label for="b">Antras skaicius</label>
                        <input type="text" id="b" name="b" value="%4$s">
                        <button type="submit">%2$S</button>
                    </form>
                </div>
                <div class="container">
                    <p>Rezultatas: %5$.2f</p>
                </div>
            </div>
        """.formatted(message, veiksmas, a, b, suma);
    }

    public static String getCompareTemplate(String message, String veiksmas, String numbers, double result) {
        return """
        <div>
                <div class="container">
                    %1$s
                    <form action="/java_servlets/calculator/%2$s" method="get">
                        <label for="numbers">Skaiciai palyginimui</label>
                        <input type="text" id="numbers" name="numbers" value="%3$s">
                       
                        <button type="compare">%2$S</button>
                    </form>
                </div>
                <div class="container">
                    <p>Rezultatas: %4$.2f</p>
                </div>
            </div>
        """.formatted(message, veiksmas, numbers, result);
    }

    public static String getCalculate(String message, String action, String input, double result) {
        return """
            <div>
                <div class="container">
                    %1$s
                    <form action="/java_servlets/calculator/%2$s" method="get">
                        <label for="compare">Palygink skaicius</label>
                        <input type="text" id="compare" name="calculate" value="%3$s">
                        <button type="submit">%2$S</button>
                    </form>
                </div>
                <div class="container">
                    <p>Rezultatas: %4$s</p>
                </div>
            </div>
            """.formatted(message, action.toLowerCase(), input, result);
    }
}
