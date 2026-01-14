package tests;

import org.junit.jupiter.api.Test;
import specs.RequestSpec;
import specs.ResponseSpec;
import java.util.Collections;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static specs.RequestSpec.BASE_URI;

public class PostTests {
    @Test
    public void postRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .spec(RequestSpec.requestSpec)
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .spec(ResponseSpec.responseSpec)
                .body("data", equalTo(requestBody))
                .body("args", equalTo(Collections.emptyMap()))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("json", nullValue())
                .body("url", equalTo(BASE_URI + "/post"));
    }

    @Test
    public void postFormData() {
        given()
                .spec(RequestSpec.requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .spec(ResponseSpec.responseSpec)
                .log().body()
                .body("data", equalTo(""))
                .body("args", equalTo(Collections.emptyMap()))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URI + "/post"));
    }
}
