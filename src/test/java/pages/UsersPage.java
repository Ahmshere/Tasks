package pages;

import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class UsersPage extends BaseSeleniumPage{


    public UsersPage createNewStatus(String message){
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Home']")));
        return new UsersPage();
    }
}
