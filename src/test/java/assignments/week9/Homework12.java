package assignments.week9;

import assignments.pojo.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;
import static io.restassured.RestAssured.given;
import static java.util.Arrays.*;
import static org.testng.Assert.assertEquals;


public class Homework12 {

    /*
    * //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
        (All actions must be done on same pet)
        (Use Pojo)
* */
    protected RequestSpecification requestSpec;

    @BeforeTest
    public void setUpBaseURL() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test(priority = 0)
    public void createPetTest(){
        requestSpec.pathParam("first", "pet");

        PetCategoryModel category = new PetCategoryModel(2, "Cats");
        PetTagsModel tag = new PetTagsModel(2, "adorable");
        PetModel pet = new PetModel(12345, category, "Whiskers", asList("http://example.com/cat-photo"), asList(tag), "available");

        Response createResponse = given(requestSpec)
                .contentType(ContentType.JSON)
                .body(pet)
                .post("{first}");
        createResponse.prettyPrint();

        assertEquals(createResponse.getStatusCode(), 200);
    }

    @Test(priority = 1)
    public void getPetTest() {
        long petId = 9223372036854775807L;
        requestSpec.pathParam("first", "pet");


        Response readResponse = given(requestSpec)
                .get("{first}/" + petId);
        readResponse.prettyPrint();


        PetModel actualPet = readResponse.as(PetModel.class);

        assertEquals(readResponse.getStatusCode(), 200);
        assertEquals(actualPet.getId(), petId);
    }

    @Test(priority = 2)
    public void updatePetTest() {
        requestSpec.pathParam("first", "pet");

        PetCategoryModel category = new PetCategoryModel(2, "Cats");
        PetTagsModel tag = new PetTagsModel(2, "adorable");
        PetModel pet = new PetModel(12345, category, "Whiskers", Arrays.asList("http://example.com/cat-photo"), asList(tag), "available");

        pet.setName("Updated Whiskers");
        pet.getPhotoUrls().set(0, "http://example.com/updated-cat-photo");
        Response updateResponse = given(requestSpec)
                .contentType(ContentType.JSON)
                .body(pet)
                .put("{first}");
        updateResponse.prettyPrint();

        assertEquals(updateResponse.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void deletePetTest(){
        requestSpec.pathParam("first", "pet");

        PetCategoryModel category = new PetCategoryModel(2, "Cats");
        PetTagsModel tag = new PetTagsModel(2, "adorable");
        PetModel pet = new PetModel(12345, category, "Whiskers", Arrays.asList("http://example.com/cat-photo"), asList(tag), "available");


        Response deleteResponse = given(requestSpec)
                .delete("{first}/" + pet.getId());
        deleteResponse.prettyPrint();

        assertEquals(deleteResponse.getStatusCode(), 200);
    }

}
