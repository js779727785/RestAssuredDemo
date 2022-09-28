package JavaConcepts;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;

public class BDDStyleGetRequestTest {
//    参数化URL，两种方式
//    @Test
//    public void pathVariable4()
//    {
//        RestAssured
//                .given()
//                .log()
//                .all()
//                .pathParam("resourcePath", "booking")
//                .when()
//                .get("https://restful-booker.herokuapp.com/{resourcePath}/{bookingId}",10)
//                .then()
//                .log()
//                .all();
//    }

    @Test
    public void NoBDDRequest(){

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/booking");//注意完整url+path
        Response response=request.get();
        String responseStr=response.asString();
        System.out.println("Response Details" + responseStr);
        ValidatableResponse validatableResponse=response.then();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
        validatableResponse.body("bookingid[3]",Matchers.equalTo(3709));
    }

    @Test
    public void GetBookingIds_VerifyStatusCode(){

        //Given
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")//注意只有完整url
//                .basePath("/booking")
//                .param("firstName", "Rahul")
                // When
                .when()
                .get("/booking")

                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify booking id at index 3
                .body("bookingid[3]", Matchers.equalTo(10))
                // To verify booking count
                .body("bookingid.sum()", Matchers.hasSize(3));
    }
}
