package Tests;

import ResponseModels.Specification;
import ResponseModels.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class CheckAvatarAndIdTest {

    @Test
    public void checkAvatarAndIdTest() {
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")//method type + request parameters that to url
                .then().log().all()// //display all data from
                .extract().body().jsonPath().getList("data", UserData.class);

        users.stream().forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("reqres.in")));

        //2 option using loop
        List<String>  avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        for (int i = 0; i < avatars.size(); i++) {
            Assertions.assertTrue(avatars.get(i).contains(ids.get(i)));
        }

    }
}
