package assignments.week9;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework9 {

    /*
        Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
    */

    protected RequestSpecification requestSpec;

    @BeforeMethod
    public void setUpBaseURL() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void createUserTest() {
        requestSpec.pathParams("first", "user");
        String jsonBody = """
                {
                    "id": 0,
                    "username": "HassanYu",
                    "firstName": "Hassan",
                    "lastName": "Alhejaili",
                    "email": "hassanalhejaili7@gmail.com",
                    "password": "123123",
                    "phone": "54548816891",
                    "userStatus": 0
                }
                """;
        Response response = given(requestSpec)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .post("/{first}");
        response.prettyPrint();

        response.then().statusCode(200);

        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.getInt("code"), 200);
    }
}
