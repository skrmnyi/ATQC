package api_RestAssure;

import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class CheckJsonSchemaOfResponseBody extends BaseApiTest {
    @Test
    public void checkSchema() {
        given()
                .spec(requestSpecification) // use request specification from BaseApiTest
                .body(requestBody) // user from BaseApiTest
                .when()
                .post()
                .then()
                .spec(responseSpecification) // use request specification from BaseApiTest
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchema(new File(System.getProperty("user.dir") +
                        "/src/main/resources/validators.json")));

    }
}
