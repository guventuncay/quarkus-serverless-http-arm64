package dev.guvenx;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class GreetingTest {

    @Test
    @TestSecurity(user = "testUser", roles = {"admin", "user"})
    void testHelloEndpointWithJWTAuth() {
        given()
                .when()
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is("hello testUser"));
    }

}
