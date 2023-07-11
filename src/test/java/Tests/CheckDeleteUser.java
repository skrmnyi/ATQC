package Tests;

import ResponseModels.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;


public class CheckDeleteUser {

    @Test
    public void checkDeleteUser() {

        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecSpecific(204));
        given()
                .when()
                .delete("/api/users/2")
                .then().log().all()
                .extract().response();
    }
}
