package assignments.week8;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Homework8 {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void executeTest() {

        spec.pathParams("first", "users");

        Map<String, Object> expectedData = expectedDataMap(496, "leader", "morpheus", "2024-04-19T15:18:56.372Z");

        System.out.println("expectedData = " + expectedData + " ");

        Response response =
                RestAssured.given(spec)
                        .body(expectedData)
                        .post("{first}");

        response.then()
                .statusCode(201)
                .body("name", equalTo(expectedData.get("name")),
                        "job", equalTo(expectedData.get("job")),
                        "id", equalTo(expectedData.get("id")),
                        "createdAt", notNullValue());
    }

    public static Map<String, Object> expectedDataMap(Integer id, String job, String name, String createdAt) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("id", id);
        expectedData.put("job", job);
        expectedData.put("name", name);
        expectedData.put("createdAt", createdAt);
        return expectedData;
    }
}
