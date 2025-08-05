package utils;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TokenUtil {
    private static String token;

    public static String getToken(String username, String password) {
        if (token == null) {
            token = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
                    .when()
                    .post(ConfigManager.getConfigValue("login.endpoint"))
                    .then()	
                    .extract()
                    .path("token");
        }
        return token;
    }
}
