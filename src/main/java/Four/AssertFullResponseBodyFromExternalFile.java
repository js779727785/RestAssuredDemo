package Four;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;

//断言整个response，不用做序列化处理
public class AssertFullResponseBodyFromExternalFile {

    public static void main(String[] args) throws IOException {

        RestAssured
                // Construct request
                .given()
                .log()
                .all()
                .baseUri("https://gorest.co.in/public-api/")
                .basePath("users/{id}")
                .pathParam("id", "2833")
                // Hit API
                .when()
                .get()
                .then()
                // Assert response
                .log()
                .all()
                .assertThat()
                // Pass full expected response body with Hamcrest matchers
                .body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/test/resources/UserDetails2833.json")))));

//                // Pass full expected response body with Hamcrest matchers
//                .body(Matchers.equalTo("{\"code\":200,\"meta\":null,\"data\":{\"id\":2833,\"name\":\"Kathline Villanveva\",\"email\":\"Kathline.Villanveva20040@test.com\",\"gender\":\"male\",\"status\":\"inactive\"}}"));
    }


}

