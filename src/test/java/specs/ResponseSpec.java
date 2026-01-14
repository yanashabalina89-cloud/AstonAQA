package specs;

import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpec {
    public static ResponseSpecification responseSpec = expect()
            .statusCode(200)
            .body("headers.host", equalTo("postman-echo.com"))
            .body("headers.accept", equalTo("*/*"))
            .body("headers.accept-encoding", equalTo("gzip, br"))
            .body("headers.x-forwarded-proto", equalTo("https"));
}