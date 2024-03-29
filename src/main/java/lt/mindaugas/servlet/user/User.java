package lt.mindaugas.servlet.user;

public record User(
        int id, String firstName, String lastName, String email, String phone
) {
}
