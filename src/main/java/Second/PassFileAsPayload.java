package Second;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;

public class PassFileAsPayload {

    @Test
    public void passJSONFileAsPayload(){

        // Creating a File instance
        File file = new File("src/main/resources/payload/authPayload.json");

        //GIVEN
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(file)
                // WHEN
                .when()
                .post()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
                .body("token.length()", Matchers.is(15))
                .body("token", Matchers.matchesRegex("^[a-z0-9]+$"));

    }
}

