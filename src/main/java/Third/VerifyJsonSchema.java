package Third;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class VerifyJsonSchema {

    @Test
    public void verifyJsonSchema() {

        String jsonStringPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

        // GIVEN
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(jsonStringPayload)
                // WHEN
                .when()
                .post()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AuthJsonSchema.json"));
//                .body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/jingshuai/zuche/test/RestAssuredDemo/src/test/resources/AuthJsonSchema.json")));
    }
    @Test
    public void verifyJsonSchemaWithoutRestAssured()
    {
        String json = "{\r\n" +
                "    \"firstname\" : \"Jim\",\r\n" +
                "    \"lastname\" : \"Brown\",\r\n" +
                "    \"totalprice\" : 111,\r\n" +
                "    \"depositpaid\" : true,\r\n" +
                "    \"bookingdates\" : {\r\n" +
                "        \"checkin\" : \"2018-01-01\",\r\n" +
                "        \"checkout\" : \"2019-01-01\"\r\n" +
                "    },\r\n" +
                "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                "}";
        MatcherAssert.assertThat(json,JsonSchemaValidator.matchesJsonSchema(new File("/Users/jingshuai/zuche/test/RestAssuredDemo/src/main/resources/payload/DemoJsonSchema.json")));
    }

}

