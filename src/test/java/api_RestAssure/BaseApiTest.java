package api_RestAssure;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

public class BaseApiTest {

    protected RequestSpecification requestSpecification;
    protected ResponseSpecification responseSpecification;
    public Map<String, Object> requestBody = new HashMap<>();

    @BeforeEach
    public void setSpecification() {   // builder pattern - create request parameters
        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://api.novaposhta.ua/v2.0/json/")
                .setContentType(ContentType.JSON)
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();

    }
    @BeforeEach
    public void setRequestBody() {
        String apiKey = "d2037b4804521a824522ef17cfc87041";
        Map<String, Object> methodProperties = new HashMap<>();

        requestBody.put("apiKey", apiKey);
        requestBody.put("modelName", "Address");
        requestBody.put("calledMethod", "searchSettlements");
        requestBody.put("methodProperties", methodProperties);

        methodProperties.put("CityName", "київ");
        methodProperties.put("Limit", "20");
        methodProperties.put("page", "2");

    }

}
