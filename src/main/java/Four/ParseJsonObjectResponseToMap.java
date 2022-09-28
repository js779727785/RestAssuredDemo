package Four;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

public class ParseJsonObjectResponseToMap {

    public static void main(String[] args) {

        Map<String,Object> responseBody = null;

        responseBody =
                RestAssured
                        .given()
                        .baseUri("https://restful-booker.herokuapp.com/")
                        .basePath("booking")
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
                        .when()
                        .post()
                        .then()
                        .extract()
                        .body()
                        // Extract response as Map<String,Object>
//                        .as(new TypeRef<List<Map<String,Object>>>() {})

                        .as(new TypeRef<Map<String,Object>>() {});

        // To print booking id
        System.out.println("Booking id is : "+responseBody.get("bookingid"));

        // If we do not use below annotation then also no problem. As we are directly casting without checking
        // so I have used it to surpass warning.
        @SuppressWarnings("unchecked")
        // Since "booking" key holds another JSON Object to parsing it again as Map.
                Map<String,Object> bookingDetails = (Map<String,Object>)responseBody.get("booking");

        System.out.println("First name is "+ bookingDetails.get("firstname"));

    }
}

