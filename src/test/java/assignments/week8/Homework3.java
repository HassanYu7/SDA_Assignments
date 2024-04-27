package assignments.week8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework3 {

    @Test
    public void testGetUser() {
        String url = "https://reqres.in/api/users/3";
        Response response = given().get(url);
        response.prettyPrint();
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");
    }
}
