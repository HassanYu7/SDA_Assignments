package assignments;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class SwaggerBaseUrl {

    protected RequestSpecification requestSpec;

    @BeforeMethod
    public void setUpBaseURL() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();
    }
}
