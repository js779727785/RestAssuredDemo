package Third;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RetrieveAndAssertContentType {

    @Test
    public void retrieveAndAssertContentType()
    {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\r\n" +
                        "    \"firstname\" : \"Jim\",\r\n" +
                        "    \"lastname\" : \"Brown\",\r\n" +
                        "    \"totalprice\" : 111,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2018-01-01\",\r\n" +
                        "        \"checkout\" : \"2019-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .post("https://restful-booker.herokuapp.com/booking");

        // Direct method to fetch Content-Type
        String contentType = response.getContentType();
        System.out.println("Content-Type of response is : "+contentType);

        // Since Content-Type is an header
        String contentType1 = response.getHeader("Content-Type");
        System.out.println("Content-Type of response is : "+contentType1);
    }

    @Test
    public void retrieveAndAssertContentType2()
    {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\r\n" +
                        "    \"firstname\" : \"Jim\",\r\n" +
                        "    \"lastname\" : \"Brown\",\r\n" +
                        "    \"totalprice\" : 111,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2018-01-01\",\r\n" +
                        "        \"checkout\" : \"2019-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .contentType(ContentType.JSON); //用 ValidatableResponseOptions 接口的 content-Type() 方法做断言
    }

}

