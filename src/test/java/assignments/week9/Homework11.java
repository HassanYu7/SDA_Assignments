package assignments.week9;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Homework11 {

    /*
        Given
            https://automationexercise.com/api/productsList
        When
            User sends a GET request
        Then
            Assert that the number of "Women" user type is 12

        Note: Print using JsonPath: response.jsonPath().prettyPrint();

    */

    private RequestSpecification requestSpec;

    @BeforeMethod
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api/")
                .build();
    }

    @Test
    public void testNumberOfWomenUsers() {

        requestSpec.pathParams("first", "productsList");

        Response response = given().spec(requestSpec).get("/{first}");
        response.jsonPath().prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<String> numberOfWomenUsers = jsonPath.getList("products.findAll { it.category.usertype.usertype == 'Women' }.category.usertype.usertype");


        Assert.assertEquals(numberOfWomenUsers.size(), 12);

    }

}
