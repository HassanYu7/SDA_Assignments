package assignments.week10;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Homework14 {


    protected RequestSpecification requestSpec;

    @BeforeTest
    public void setUpBaseURL() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com/")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void verifyEmployeeData() {
        requestSpec.pathParams("first", "api", "second", "v1", "third", "employees");

        Response response = given(requestSpec).get("{first}/{second}/{third}");

        assertEquals(response.statusCode(), 200);

        response.then().body("data", hasSize(24));

        response.then().body("data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));

        int maxAge = response.then().extract().path("data.employee_age.max()");
        assertEquals(maxAge, 66);

        String lowestAgeName = response.then().extract().path("data.min { it.employee_age }.employee_name");
        assertEquals(lowestAgeName, "Tatyana Fitzpatrick");

        int totalSalary = response.then().extract().path("data.employee_salary.sum()");
        assertEquals(totalSalary, 6644770);
    }
}
