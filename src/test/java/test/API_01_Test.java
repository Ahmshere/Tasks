package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.UserData;

import java.util.List;

import static io.restassured.RestAssured.given;

public class API_01_Test {
    private final static String URL = "https://reqres.in/";
    @Test
    public void tstHello(){
        Response response = RestAssured.get("https://playground.learnqa.ru/api/hello").andReturn();
        response.prettyPrint();
    }

    @Test
    public void testReqres(){
     Response res = RestAssured.get("https://reqres.in/api/users?page=2").andReturn();
     // res.prettyPrint();
        List<UserData> u = res.then().log().all().extract().body().jsonPath().getList("data", UserData.class);
        System.out.println("Status CODE : "+res.statusCode());
        System.out.println("Status LINE : "+res.statusLine());

    }

    @Test
    public void reqRes(){

        // given() - Osnovnoi method. s nego nachinautsa vse zaprosi po HTTP protokolu
        List<UserData> users = given()
                .when().contentType(ContentType.JSON)
                .get(URL+"api/users?page=2").then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
// Vmesto get() mogut bit lubie http metodi!
        users.stream().forEach(x-> {
            Assert.assertTrue(x.getAvatar().contains(x.getId().toString()));
        });
        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));
    }

}

