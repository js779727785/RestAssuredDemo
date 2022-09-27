package Third;

import io.restassured.http.ContentType;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RetrievingResponseHeaders {

    @Test
    public void getALlHeadersFromResponse()
    {
        Response response=
                RestAssured
                        .given()
                        .get("https://restful-booker.herokuapp.com/booking/1")
                        .then()
                        .extract()
                        .response();

        System.out.println("All Headers of response are :- ");
        Headers allHeaders = response.getHeaders();
        for(Header header : allHeaders)
        {
            System.out.print(header.getName() +" : ");
            System.out.println(header.getValue());
        }

        System.out.println("Value of Header Content-Type : "+response.getHeader("Content-Type"));
        //get结果做header断言用hasHeaderWithName
//        boolean isPresent = response.getHeaders().hasHeaderWithName("Content-Type");


//        // Suppose Content-Type is a multivalue header
//        List<Header> allValue = response.getHeaders().getList("Content-Type");
//        for(Header header : allValue)
//        {
//            System.out.print(header.getName() +" : ");
//            System.out.println(header.getValue());
//        }
//
//        List<String> allValue1 = response.getHeaders().getValues("Content-Type");
//        for(String value : allValue1)
//        {
//            System.out.println(value);
//        }


    }

}

