package assignments.week10.hw13;

import assignments.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static assignments.utilities.ObjectMapperUtils.convertJsonToJava;
import static assignments.week10.hw13.CreateUser.username;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
public class GetUser extends SwaggerBaseUrl {


    @Test
    public void verifyGetUser() {
        requestSpec.pathParams("first", "user","second",username);

        String strJson = """
                {
                  "id": 2033,
                  "username": "HassanYu",
                  "firstName": "Hassan",
                  "lastName": "Alhejaili",
                  "email": "HassanAlhejaili7@gmail.com",
                  "password": "123123",
                  "phone": "0548816891",
                  "userStatus": 0
                }
                """;

        Map expectedData = convertJsonToJava(strJson, Map.class);

        Response response = given(requestSpec).get("{first}/{second}");
        Map actualData = convertJsonToJava(response.asString(), Map.class);

        response.then().statusCode(200);
        assertEquals(actualData.get("id"), expectedData.get("id"));
        assertEquals(actualData.get("username"), expectedData.get("username"));
        assertEquals(actualData.get("firstName"), expectedData.get("firstName"));
        assertEquals(actualData.get("lastName"), expectedData.get("lastName"));
        assertEquals(actualData.get("email"), expectedData.get("email"));
        assertEquals(actualData.get("password"), expectedData.get("password"));
        assertEquals(actualData.get("phone"), expectedData.get("phone"));
        assertEquals(actualData.get("userStatus"), expectedData.get("userStatus"));
    }
}
