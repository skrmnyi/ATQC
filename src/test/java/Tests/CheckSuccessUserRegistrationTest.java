package Tests;

import ResponseModels.RegistrationUserReq;
import ResponseModels.Specification;
import ResponseModels.SuccessRegResp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertAll;


public class CheckSuccessUserRegistrationTest {

    @Test
    public void checkSuccessUserRegistrationTest() {
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecOK200());
        int id = 4;
        String token = "QpwL5tke4Pnpja7X4";
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
}
