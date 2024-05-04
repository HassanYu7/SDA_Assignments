package assignments.week10.hw13;

import assignments.SwaggerBaseUrl;
import assignments.pojo.User;
import org.testng.annotations.Test;

import static assignments.utilities.ObjectMapperUtils.convertJsonToJava;
import static assignments.week10.hw13.CreateUser.username;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class UpdateUser extends SwaggerBaseUrl {

    @Test
    public void verifyUpdateUser() {

        requestSpec.pathParams("first", "user","second",username);

        String strJson = """
                {
                  "id": 2033,
                  "username": "HassanYu",
                  "firstName": "Ahmed",
                  "lastName": "Alhejaili",
                  "email": "HassanAlhejaili7@gmail.com",
                  "password": "123123",
                  "phone": "0548816891",
                  "userStatus": 0
                }
                """;

        User expectedData = convertJsonToJava(strJson, User.class);

        Response response = given(requestSpec).body(expectedData).put("{first}/{second}");

        response.then().statusCode(200);
    }
}
