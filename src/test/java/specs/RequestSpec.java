package specs;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RequestSpec {
    public static final String BASE_URI = "https://postman-echo.com";
    public static RequestSpecification requestSpec = given()
            .baseUri(BASE_URI)
            .accept("*/*");
}

