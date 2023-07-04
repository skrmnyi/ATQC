package Tests;

import ResponseModels.UserData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegressTest {
    private final static String URL = "https://reqres.in/";
    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"api/users?page=2")//method type
                .then().log().all()// //display all data from
                .extract().body().jsonPath().getList("data",UserData.class);
        users.stream().forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));



    }
}
