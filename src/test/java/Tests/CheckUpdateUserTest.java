package Tests;

import ResponseModels.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;


public class CheckUpdateUserTest {

    @Test
    public void checkUpdateUserTest() {

        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecOK200());
        UpdateUser updateUser = new UpdateUser("newUserName", "QA engineer");
        Response response = given()
                .body(updateUser)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        assertAll(
                () ->Assertions.assertEquals(jsonPath.get("name"), updateUser.getName()),
                () -> Assertions.assertEquals(jsonPath.get("job"), updateUser.getJob())
        );
    }
}
