package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    @Test
    public void createUser(){

        UserPojo userPojo = new UserPojo();

        userPojo.setId(124);
        userPojo.setUsername("HarryP");
        userPojo.setFirstName("Harry");
        userPojo.setLastName("Potter");
        userPojo.setEmail("H.Porter" + getRandomValue() + "@email.com");
        userPojo.setPassword("abc123");
        userPojo.setPhone("012345678");
        userPojo.setUserStatus(1);
        Response response=given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/user");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getUserByUserId(){
        Response response=given()
                .when()
                .get("/user/HarryP");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void updateUserByUserName(){

        UserPojo userPojo = new UserPojo();

        userPojo.setId(124);
        userPojo.setUsername("HarryP");
        userPojo.setFirstName("Harry");
        userPojo.setLastName("Potter");
        userPojo.setEmail("Harry.Porter" + getRandomValue() + "@email.com");
        userPojo.setPassword("abc123");
        userPojo.setPhone("012345678");
        userPojo.setUserStatus(1);

        Response response=given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .put("/user/HarryP");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void deleteUserByUsername(){

        Response response=given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/user/HarryP");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
