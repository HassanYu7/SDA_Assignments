package assignments.week10.hw13;

import assignments.SwaggerBaseUrl;
import org.testng.annotations.Test;

import static assignments.week10.hw13.CreateUser.username;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteUser extends SwaggerBaseUrl {

    @Test
    public void verifyDeleteUser() {
        requestSpec.pathParams("first", "user","second",username);
        Response response = given(requestSpec).delete("{first}/{second}");
        response.then().statusCode(200);
    }
}
