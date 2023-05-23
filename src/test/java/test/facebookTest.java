package test;

import core.ConfigProvider;
import org.junit.jupiter.api.Test;
import pages.BaseSeleniumTest;
import pages.MainPage;
import pages.UsersPage;

public class facebookTest extends BaseSeleniumTest {
    @Test
    public void facebookTest_Status(){
        UsersPage userPage = new MainPage().login(ConfigProvider.USER_LOGIN, ConfigProvider.USER_PASSWORD)
                .createNewStatus(ConfigProvider.USER_MESSAGE);
    }
}
