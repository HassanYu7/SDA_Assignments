package assignments.week8;

import io.restassured.path.json.JsonPath;
import java.util.List;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Homework7 {


    @Test
    public void userRequestTest() {


        String url = "https://reqres.in/api/unknown/";





        Response response =
                given()
                        .get(url)
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();


        JsonPath jsonPath = response.jsonPath();

        // Print all pantone_values
        List<String> pantoneValues = jsonPath.getList("data.pantone_value");
        System.out.println("Pantone Values: " + pantoneValues);

        // Print all ids greater than 3 and assert that there are 3 ids greater than 3
        List<Integer> idsGreaterThan3 = jsonPath.getList("data.findAll { it.id > 3 }.id");
        System.out.println("IDs greater than 3: " + idsGreaterThan3);
        assertEquals(idsGreaterThan3.size(), 3);

        // Print all names whose ids are less than 3 and assert that the number of names whose ids are less than 3 is 2
        List<String> namesLessThan3 = jsonPath.getList("data.findAll { it.id < 3 }.name");
        System.out.println("Names with IDs less than 3: " + namesLessThan3);
        assertEquals(2, namesLessThan3.size());

    }
}
