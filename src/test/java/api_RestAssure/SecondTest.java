package api_RestAssure;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SecondTest extends BaseApiTest {
    // better implementation with inheritance and dry principle

    @Test
    public void checkResponseStatus() {

        given()
                .spec(requestSpecification) // use request specification from BaseApiTest
                .body(requestBody) // user from BaseApiTest
                .when()
                .post()
                .then()
                .spec(responseSpecification) // use request specification from BaseApiTest
                .statusCode(200)
                .assertThat()
                .body("success", equalTo(true));
    }

}
