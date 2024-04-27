package assignments.week8;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Homework4 {

    @Test
    public void validateUserDetailsForId2() {

        String url = "https://reqres.in/api/users/2";

        Response response = given().get(url);
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }

}
