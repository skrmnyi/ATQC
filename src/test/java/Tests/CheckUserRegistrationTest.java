package Tests;

import ResponseModels.*;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;


public class CheckUserRegistrationTest {
    private Integer id = 4;
    private String token = "QpwL5tke4Pnpja7X4";

    @Test
    public void checkSuccessUserRegistrationTest() {
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecOK200());
        RegistrationUserReq user = new RegistrationUserReq("eve.holt@reqres.in", "pistol");

        SuccessRegResp successRegResp = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegResp.class);

        Assertions.assertEquals(id, successRegResp.getId());
        Assertions.assertEquals(token, successRegResp.getToken());

        //2nd option with multiple asserts -> test would make all checks even some is failed
        assertAll(
                () -> Assertions.assertEquals(id, successRegResp.getId()),
                () -> Assertions.assertEquals(token, successRegResp.getToken())
        );
    }

    @Test
    public void checkUnSuccessUserRegistrationTest() {
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecError400());

        RegistrationUserReq user = new RegistrationUserReq("sydney@fife", "");
        UnSuccessRegResp unSuccessRegResps = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessRegResp.class);
        Assertions.assertEquals("Missing password", unSuccessRegResps.getError());
    }

    @Test
    public void checkRegisteredUserIsSaved() {

        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecOK200());
        Response response = given()
                .when()
                .get("/api/users/" + id.toString())
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Assertions.assertEquals(jsonPath.get("data.id"), id);
    }
}
