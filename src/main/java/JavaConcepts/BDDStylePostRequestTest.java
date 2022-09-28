package JavaConcepts;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

public class BDDStylePostRequestTest {
    @Test
    public void getAuthNoBdd(){
        String jsonString =  "{\"username\" : \"admin\",\"password\" : \"password123\"}";
        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonString);
        Response response= requestSpecification.when().post();
        System.out.print(response.asString());
        ValidatableResponse vres= response.then();
        vres.statusCode(200);
        vres.body("token", Matchers.notNullValue());
        vres.body("token.length()", Matchers.is(15));
    }

    @Test
    public void getAuth(){
        String jsonString =  "{\"username\" : \"admin\",\"password\" : \"password123\"}";
        RestAssured.given()
                .contentType(ContentType.JSON)
//                .cookie("token", "a85a7d366eaae41")
                .baseUri("https://restful-booker.herokuapp.com")
                .body(jsonString)
                .when()
                .post("/auth")
                .then()
                .statusCode(200);
    }
    //设置超时时间
    @Test
    void case2(){
        // 自定义HttpClientConfig对象
        // 设置响应超时时长为3秒，单位是毫秒
        HttpClientConfig clientConfig = HttpClientConfig
                .httpClientConfig()
                .setParam("http.socket.timeout", 3000);
        // 定义RestAssuredConfig对象
        // 传入自定义的HttpClientConfig对象
        RestAssuredConfig myTimeout = RestAssuredConfig
                .config()
                .httpClient(clientConfig);

        // 接口调用
        RestAssured.given()
                .config(myTimeout)  // 设置超时处理
                .when()
                .get("/delay/10")  // 特定接口，延迟10秒响应
                .then()
                .statusCode(200);  // 响应断言
    }

}
