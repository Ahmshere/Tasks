package core;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile") ?
                ConfigFactory.load(ConfigFactory.systemProperties().getString("resources")) :
                ConfigFactory.load("app.conf");
        }

    String URL_FACEBOOK = readConfig().getString("facebook_url");
    String URL_WALLETHUB = readConfig().getString("wallethub");
    String USER_LOGIN = readConfig().getString("usersParams.admin.login");
    String USER_PASSWORD = readConfig().getString("usersParams.admin.password");
    String USER_MESSAGE = readConfig().getString("message_");

    String TEST_URL = "https://www.ebay.com/";
}
