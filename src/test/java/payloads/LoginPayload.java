package payloads;

public class LoginPayload {
    public static String getLoginPayload(String username, String password) {
        return "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";
    }
}
