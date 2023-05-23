package pages;

import core.ConfigProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage{
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailOrPhoneNumberField;
    @FindBy(xpath = "//input[@id='pass']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@name='login']")
    WebElement loginButton;

    public MainPage() {
        setDriver(driver);
       // driver.switchTo().window(driver.getWindowHandle());
        driver.get(ConfigProvider.URL_FACEBOOK);
        PageFactory.initElements(driver, this);
    }
    public UsersPage login(String login, String password){
        emailOrPhoneNumberField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new UsersPage();
    }
}
