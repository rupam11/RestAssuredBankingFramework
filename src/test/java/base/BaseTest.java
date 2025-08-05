package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import config.ConfigLoader;

import java.util.Properties;

public class BaseTest {

    protected RequestSpecification requestSpec;
    protected static Properties config;

    @BeforeClass
    public void setup() {
        // Load config file
        config = ConfigLoader.loadProperties("src/test/resources/config.properties");

        // Set base URI
        RestAssured.baseURI = config.getProperty("base.uri");
    }
}
