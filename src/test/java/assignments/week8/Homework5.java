package assignments.week8;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Homework5 {

    @Test
    public void validateErrorResponse() {
        String url = "https://reqres.in/api/users/23";

        Response response = given().get(url);
        response.prettyPrint();

        response.then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "cloudflare")
                .body(equalTo("{}"));
    }
}
