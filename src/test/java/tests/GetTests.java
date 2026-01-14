package tests;

import org.junit.jupiter.api.Test;
import specs.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static specs.RequestSpec.BASE_URI;

public class GetTests {
    @Test
    public void getRequest() {
        given()
                .spec(RequestSpec.requestSpec)
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .spec(ResponseSpec.responseSpec)
                .log().body()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URI + "/get?foo1=bar1&foo2=bar2"));
    }
}
