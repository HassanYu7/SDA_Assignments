package assignments.week9;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
public class Homework10 {

    /*
     * Using the https://petstore.swagger.io/ document,
     * write an automation test that finds the number of "pets" with the status "available" and
     * asserts that there are more than 100.
     *
     * */

    private RequestSpecification requestSpec;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void testCountAvailablePets() {
        requestSpec.pathParams("first","pet","second","findByStatus");

        Response response = given()
                .spec(requestSpec)
                .queryParam("status", "available")
                .get("/{first}/{second}");

        response.prettyPrint();


        List<String> petStatuses = response.jsonPath().getList("findAll { it.status == 'available' }.status");
        Assert.assertTrue(petStatuses.size() > 100);

    }
}
