package test;
import core.ConfigProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;
import pages.TestPage;
import pages.UserData;
import pages.UsersPage;

import java.net.URL;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GridTestClass {
    private final static String URL = "https://reqres.in/";
    @Test
    public static void reqRes(){

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
    public static void facebookTest_Status(){
        UsersPage userPage = new MainPage().login(ConfigProvider.USER_LOGIN, ConfigProvider.USER_PASSWORD)
                .createNewStatus(ConfigProvider.USER_MESSAGE);
    }

    @Test
    public static void testReqres(){
        Response res = RestAssured.get("https://reqres.in/api/users?page=2").andReturn();
        // res.prettyPrint();
        List<UserData> u = res.then().log().all().extract().body().jsonPath().getList("data", UserData.class);
        System.out.println("Status CODE : "+res.statusCode());
        System.out.println("Status LINE : "+res.statusLine());

    }
    @Test
    public static void testTestURL() throws InterruptedException {
        TestPage tp = new TestPage();
        tp.searchFieldValueSet("guitar");


    }
    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.14.8:4444/wd/hub"), capabilities);

        // Запуск теста в Firefox
       // DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
       // WebDriver firefoxDriver = new RemoteWebDriver(new URL("http://192.168.14.8:4444/wd/hub"), firefoxCapabilities);

        // Ваш тест 192.168.14.8
        testReqres();
       // reqRes();
     //   testTestURL();
       // facebookTest_Status();


       // firefoxDriver.quit();
        driver.quit();
    }
}
