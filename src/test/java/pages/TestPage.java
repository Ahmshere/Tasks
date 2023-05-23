package pages;

import core.ConfigProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage extends  BaseSeleniumPage{
    @FindBy(xpath = "//input[@id='gh-ac']")
    WebElement searchField;
    public TestPage() {
        driver.get(ConfigProvider.TEST_URL);
        PageFactory.initElements(driver, this);
    }
    public void searchFieldValueSet(String value) throws InterruptedException {
        searchField.sendKeys(value, Keys.ENTER);
        Thread.sleep(10000);
    }

}
