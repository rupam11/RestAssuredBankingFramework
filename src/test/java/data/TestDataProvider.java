package data;

import org.testng.annotations.DataProvider;


public class TestDataProvider {
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][] {
                {"testuser1", "password123"},
                {"adminuser", "admin@123"}
        };
    }
}
