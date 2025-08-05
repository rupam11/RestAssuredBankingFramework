package mockserver;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class MockedLoginTests {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"testuser1", "password@123", 200},
            {"adminuser", "admin@123", 200},
            {"invaliduser", "wrongpass", 401}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLoginAPI(String username, String password, int expectedStatusCode) {
        // Mock API endpoint - replace with your actual endpoint
        String endpoint = "https://mockapi.example.com/login";

        // Build request body
        String requestBody = String.format("{ \"username\": \"%s\", \"password\": \"%s\" }", username, password);

        // Send POST request
        Response response = RestAssured
            .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
            .when()
                .post(endpoint)
            .then()
                .extract()
                .response();

        // Print response for debugging
        System.out.println("Response for user: " + username);
        response.prettyPrint();

        // Assert status code
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code mismatch for user: " + username);
    }
}
