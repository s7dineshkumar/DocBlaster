package utils;

import org.junit.AfterClass;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static RemoteWebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
 /*   @org.testng.annotations.AfterClass
    public void getDriverClose(){
        driver.close();
    }*/

        public Object getPage(Class pageClass) {
        return PageFactory.initElements(getDriver(), pageClass);
    }

}
