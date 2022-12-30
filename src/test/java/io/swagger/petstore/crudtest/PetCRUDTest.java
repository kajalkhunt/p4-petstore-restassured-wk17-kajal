package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetCRUDTest extends TestBase {

    @Test
    public void addNewPet() {
        PetPojo petPojo = new PetPojo();

        petPojo.setId(788);

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("id", 120);
        newCategory.put("name", "Prince");
        petPojo.setCategory(newCategory);

        petPojo.setName("doggie");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.dreamstime.com/royalty-free-stock-image-golden-retriever-dog-image21668976/");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 121);
        tagHash.put("name", "Dog");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response=given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post("/pet");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void findPetById(){
        Response response=given()
                .when()
                .get("/pet/788");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void updateExistingPetDetail(){

        PetPojo petPojo = new PetPojo();

        petPojo.setId(788);

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("id", 120);
        newCategory.put("name", "Prince");
        petPojo.setCategory(newCategory);

        petPojo.setName("doggie");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.dreamstime.com/royalty-free-stock-image-golden-retriever-dog-image21668976/");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 121);
        tagHash.put("name", "prince");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response=given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .put("/pet");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deletePet(){

        Response response=given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/pet/788");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
