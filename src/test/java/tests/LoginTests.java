package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import data.TestDataProvider;
import io.qameta.allure.*;
import io.restassured.response.Response;
import payloads.LoginPayload;


@Epic("Banking Project")
@Feature("Login API")
public class LoginTests extends BaseTest {

    @Story("Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify user can login with valid credentials", dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void testSuccessfulLogin() {
        Response response = requestSpec
                .body(LoginPayload.getLoginPayload("testUser", "testPass"))
                .when()
                //.post("/api/v1/login");
        		.post("api/auth/login");

        response.then().statusCode(200);
    }
}
