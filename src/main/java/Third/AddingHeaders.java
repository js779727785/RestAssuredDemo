package Third;

import java.util.HashMap;
import java.util.Map;


import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.junit.Test;


/**
 * 推荐使用：Add header with multiple values
 * 了解headerConfig
 * **/
public class AddingHeaders {

    @Test
    public void addKeyvaluePairHeaders() {

        // Add a header as key value
        System.out.println("Add a header as key value");
        RestAssured.given()
                .header("someHeader","somevalue")
                .headers("someHeader","somevalue")
                .log().headers()
                .get("https://restful-booker.herokuapp.com/booking/10");

        // Add header as a Map
        System.out.println("Add header as a Map");
        Map<String,String> requestHeaders = new HashMap();
        requestHeaders.put("someHeader","somevalue");
        RestAssured.given()
                .headers(requestHeaders)
                .log().headers()
                .get("https://restful-booker.herokuapp.com/booking/10");


        // Add header using Header class
        System.out.println("Add header using Header class");
        Header requestHeader1 = new Header("someHeader","somevalue");
        RestAssured.given()
                .header(requestHeader1)
                .log().headers()
                .get("https://restful-booker.herokuapp.com/booking/10");

        // Add header using Header and Headers class
        System.out.println("Add header using Header and Headers class");
        Header requestHeader2 = new Header("someHeader","somevalue");
        Headers requestHeaders3 = new Headers(requestHeader2);
        RestAssured.given()
                .headers(requestHeaders3)
                .log().headers()
                .get("https://restful-booker.herokuapp.com/booking/10");

        // Add header with multiple values
        System.out.println("Add header with multiple values");
        RestAssured.given()
                .header("someHeader","someFirstvalue", "someSecondvalue")
                .log().headers()
                .get("https://restful-booker.herokuapp.com/booking/10");

        // Changing default behavior of merging
        System.out.println("Changing default behavior of merging");
        RestAssured.given()
                .config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().mergeHeadersWithName("header1")))
                .header("header1","someFirstvalue")
                .header("header1","someSecondvalue")
                .log().headers()
                .get("https://restful-booker.herokuapp.com/booking/10");

        // Change overwrite behavior if not
        System.out.println("Change overwrite behavior if not");
        RestAssured.given()
                .config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("header1")))
                .header("header1","someFirstvalue")
                .header("header1","someSecondvalue")
                .log().headers()
                .get("https://restful-booker.herokuapp.com/booking/10");

    }
}

