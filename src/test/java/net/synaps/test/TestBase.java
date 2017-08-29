package net.synaps.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.close;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;

public class TestBase {

    public AndroidDriver driver;
    /*
    public static final String USERNAME = System.getenv("BROWSERSTACK_USER");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
*/
    @Before
    public void setUp() throws MalformedURLException {
        Configuration.timeout = 10000;
/*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "App Testing Android");
        caps.setCapability("name", "sample java");
        caps.setCapability("platformName", "android");
        caps.setCapability("device", "Google Nexus 6");
        caps.setCapability("realMobile", true);
        caps.setCapability("app", System.getenv("ANDROID_APP_URL"));

        driver = new AndroidDriver(new URL(URL), caps);
*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "d32d9b2b7ce4");
        capabilities.setCapability(APP_PACKAGE, "co.nomadlabs.chat");
        capabilities.setCapability(APP_ACTIVITY, "co.nomadlabs.chat.ui.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void closeAppiumDriver() throws Exception {
        close();
    }


}
