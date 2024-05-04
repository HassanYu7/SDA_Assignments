package assignments.week10.hw13;

import assignments.SwaggerBaseUrl;
import assignments.pojo.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static assignments.utilities.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;

public class CreateUser extends SwaggerBaseUrl {

    //Write an automation test that will create a 'user' then read,
    // update and delete the created user using the "https://petstore.swagger.io/" document.
    // (Create a classes for each request.)

    public static String username;


    @Test
    public void verifyCreateUser() {
        requestSpec.pathParams("first", "user");

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

        User expectedData = convertJsonToJava(strJson, User.class);

        Response response = given(requestSpec).body(expectedData).post("{first}");

        response.then().statusCode(200);
        username = expectedData.getUsername();
    }
}
