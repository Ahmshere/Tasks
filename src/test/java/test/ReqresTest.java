package test;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.Support;
import pages.UserData;

import java.util.List;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReqresTest {
    private static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarIdTest(){

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

    @Test
    public void updateRecordsWinthPut(){
        List<Support> supportPages = given().spec(REQUEST_SPECIFICATION)
                .when()
                .get(URL+"api/users").then().log().all()
                .extract().body().jsonPath().getList("text", Support.class);
        // Assertions.assertTrue(supportPages.stream().allMatch(x->x.getText().contains("ReqRes")));
        System.out.println("***** RESULT : "+supportPages.size());




        // Assertions.assertEquals(CODE_200, resCode);
    }


}
// https://www.youtube.com/watch?v=gxzXOMxIt4w
// https://www.youtube.com/watch?v=z9Tvxh6uQzI
// АПИ и ГУИ вместе! https://www.youtube.com/watch?v=V6NotcHVhG0

