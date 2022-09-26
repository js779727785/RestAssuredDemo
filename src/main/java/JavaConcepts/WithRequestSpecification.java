package JavaConcepts;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.BeforeClass;


/**
 *  神州租车用的语法大部分是：RestAssured.given(requestSpecification)
 * **/
public class WithRequestSpecification {

    static RequestSpecification requestSpecification;

    @BeforeClass
    public static void setupRequestSpecification()
    {
        requestSpecification = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking");
    }

    @Test
    public void getAllBookings()
    {
        // Given
        RestAssured
                .given()
                .spec(requestSpecification)
                // When
                .when()
                .get()
                // Then
                .then()
                .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void getBookingDetailsWithInvalidFirstName()
    {
        // Given
        RestAssured
                .given(requestSpecification)
                .param("firstName", "Rahul")
                // When
                .when()
                .get()
                // Then
                .then()
                .statusLine("HTTP/1.1 200 OK");
    }

}
