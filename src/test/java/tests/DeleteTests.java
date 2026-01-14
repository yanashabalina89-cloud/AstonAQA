package tests;

import org.junit.jupiter.api.Test;
import specs.RequestSpec;
import specs.ResponseSpec;
import java.util.Collections;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static specs.RequestSpec.BASE_URI;

public class DeleteTests {
    @Test
    public void deleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .spec(RequestSpec.requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .spec(ResponseSpec.responseSpec)
                .body("data", equalTo(requestBody))
                .body("args", equalTo(Collections.emptyMap()))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("json", nullValue())
                .body("url", equalTo(BASE_URI + "/delete"));
    }
}
