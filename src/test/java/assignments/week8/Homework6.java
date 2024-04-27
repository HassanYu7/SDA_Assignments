package assignments.week8;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Homework6 {

    private RequestSpecification spec;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
        spec = given().baseUri(RestAssured.baseURI);
    }

    @Test
    void userRequestTest() {
        spec.pathParams("first", "unknown", "second", "3");

        Response response =
                spec.get("/{first}/{second}")
                        .then().statusCode(200)
                        .contentType("application/json; charset=utf-8")
                        .extract()
                        .response();

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3);
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002);
        softAssert.assertEquals(jsonPath.getString("data.color"), "#BF1932");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"), "19-1664");
        softAssert.assertEquals(jsonPath.getString("support.url"), "https://reqres.in/#support-heading");
        softAssert.assertEquals(jsonPath.getString("support.text"), "To keep ReqRes free, contributions towards server costs are appreciated!");
        softAssert.assertAll();
    }

}
