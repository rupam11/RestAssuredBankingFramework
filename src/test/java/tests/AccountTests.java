package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import mockserver.WireMockServerSetup;
import org.testng.annotations.*;
import com.aventstack.extentreports.Status;
import reports.ExtentTestManager;

import static io.restassured.RestAssured.given;

public class AccountTests extends BaseTest {

    @BeforeClass
    public void setup() {
        WireMockServerSetup.startMockServer(); // Start mock server
        RestAssured.baseURI = "http://localhost:8080"; // Mock base URI
    }

    @Test
    public void verifyAccountDetailsAPI() {
        ExtentTestManager.startTest("Verify Account Details API", "Verify mocked account details endpoint");

        Response response = given()
                .when()
                .get("/account/details")
                .then()
                .extract()
                .response();

        ExtentTestManager.getTest().log(Status.INFO, "API Response: " + response.asString());

        int statusCode = response.getStatusCode();
        String accountNumber = response.jsonPath().getString("accountNumber");

        if (statusCode == 200 && accountNumber.equals("123456789")) {
            ExtentTestManager.getTest().log(Status.PASS, "Account details verified successfully");
        } else {
            ExtentTestManager.getTest().log(Status.FAIL, "Account details verification failed");
        }
    }

    @AfterClass
    public void tearDown() {
        WireMockServerSetup.stopMockServer(); // Stop mock server
    }
}
