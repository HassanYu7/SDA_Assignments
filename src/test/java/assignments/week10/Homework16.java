package assignments.week10;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
public class Homework16 {

    protected RequestSpecification requestSpec;

    @BeforeTest
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com/")
                .setContentType(ContentType.JSON)
//                .addHeader("Authorization", "")
                .build();
    }

    @Test
    public void testContactCRUD() {
        SoftAssert softAssert = new SoftAssert();

        Response addResponse = addContact("John", "Doe", "johndoe@example.com");
        softAssert.assertEquals(addResponse.getStatusCode(), 201);
        String contactId = addResponse.jsonPath().getString("_id");

        Response readResponse = getContact(contactId);
        softAssert.assertEquals(readResponse.getStatusCode(), 200);

        Response updateResponse = updateContact(contactId, "Jane", "Doe", "janedoe@example.com");
        softAssert.assertEquals(updateResponse.getStatusCode(), 200);

        Response deleteResponse = deleteContact(contactId);
        softAssert.assertEquals(deleteResponse.getStatusCode(), 200);

        Response negativeReadResponse = getContact(contactId);
        softAssert.assertEquals(negativeReadResponse.getStatusCode(), 404);
        softAssert.assertEquals(negativeReadResponse.getBody().asString(), "Contact not found");

        softAssert.assertAll();
    }

    private Response addContact(String firstName, String lastName, String email) {
        return given()
                .spec(requestSpec)
                .body("{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"email\": \"" + email + "\" }")
                .post("/contacts");
    }

    private Response getContact(String contactId) {
        return given()
                .spec(requestSpec)
                .get("/contacts/" + contactId);
    }

    private Response updateContact(String contactId, String firstName, String lastName, String email) {
        return given()
                .spec(requestSpec)
                .body("{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"email\": \"" + email + "\" }")
                .put("/contacts/" + contactId);
    }

    private Response deleteContact(String contactId) {
        return given()
                .spec(requestSpec)
                .delete("/contacts/" + contactId);
    }
}
