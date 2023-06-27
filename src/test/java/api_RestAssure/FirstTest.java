package api_RestAssure;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


// not a good example - some data should be used a configuration or reusable method and shouldn't repeat
public class FirstTest {

    @Test
    public void checkThatStatusIsOk() {

        String apiKey = "d2037b4804521a824522ef17cfc87041";
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> methodProperties = new HashMap<>();

        requestBody.put("apiKey", apiKey);
        requestBody.put("modelName", "Address");
        requestBody.put("calledMethod", "searchSettlements");
        requestBody.put("methodProperties", methodProperties);

        methodProperties.put("CityName", "київ");
        methodProperties.put("Limit", "20");
        methodProperties.put("page", "2");


        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://api.novaposhta.ua/v2.0/json/")
                .then().log().all() //to display all response
                .statusCode(200)
                .assertThat()
                .body("success", equalTo(true));
    }



}



