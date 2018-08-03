package wmethods;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Reporters;

import java.io.*;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DBMethods extends Reporters implements DocInterface {

    public static RemoteWebDriver driver;
    public Properties prop;
    public String sUrl;

    public DBMethods() {

        //Properties prop = new Properties();
        try {
            prop = new Properties();
            prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
            sUrl = prop.getProperty("URL");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startApp(String browser, boolean bReturns) throws MalformedURLException {
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(browser);
            dc.setPlatform(Platform.WINDOWS);
            //local run:
            if (bReturns) {
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else {
                System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64bit.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(sUrl);
            reportStep("The browser " + browser + " has launched successfully", "PASSS");
        } catch (Exception e) {
            reportStep("The browser " + browser + " could not be launched", "FAIL");
        }
    }

    public void startApp(String browser) {
        try {
            startApp(browser, false);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WebElement locateElement(String locator, String locValue) {

        try {
            switch (locator) {
                case ("id"):
                    return driver.findElementById(locValue);
                case ("name"):
                    return driver.findElementByName(locValue);
                case ("class"):
                    return driver.findElementByClassName(locValue);
                case ("link"):
                    return driver.findElementByLinkText(locValue);
                case ("xpath"):
                    return driver.findElementByXPath(locValue);
                case ("css"):
                    return driver.findElementByCssSelector(locValue);
                case ("tag"):
                    return driver.findElementByTagName(locValue);
            }
        } catch (NoSuchElementException e) {
            reportStep("The element with the locator " + locator + " is not found.", "FAIL");
        } catch (WebDriverException e) {
            reportStep("Unknown exception occured while finding " + locator + " with the value " + locValue, "FAIL");
        }
        return null;
    }

    @Override
    public WebElement locateElement(String locValue) {
        return driver.findElementById(locValue);
    }

    @Override
    public void typeInp(WebElement ele, String data) {
        try {
            ele.clear();
            ele.sendKeys(data);
            String tval = "" + ele;
            reportStep("The data " + data + " has entered successfully in field: " + ele, "PASS");
        } catch (InvalidElementStateException e) {
            reportStep("The data: " + data + " could not be entered in the field :" + ele, "FAIL");
        } catch (WebDriverException e) {
            reportStep("Unknown exception occured while entering " + data + " in the field :" + ele, "FAIL");
        }
    }

    @Override
    public WebElement click(WebElement ele) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            text = ele.getText();
            ele.click();
            reportStep("The element " + text + " is clicked successfully", "PASS");
        } catch (InvalidElementStateException e) {
            reportStep("The element " + text + " could not be clicked", "FAIL");
        } catch (WebDriverException e) {
            reportStep("Unknown exception occurred while clicking on the field :", "FAIL");
        }
        return ele;
    }

    public String getText(WebElement ele) {
        String bReturn = "";
        try {
            bReturn = ele.getText();
        } catch (WebDriverException e) {
            reportStep("The element: " + ele + " could not be found.", "FAIL");
        }
        return bReturn;
    }

    public void closeBrowser() {
        try {
            driver.close();
            reportStep("The browser is closed", "PASS", false);
        } catch (Exception e) {
            reportStep("The browser could not be closed", "FAIL", false);
        }
    }

    public void closeAllBrowsers() {
        try {
            driver.quit();
            reportStep("The opened browsers are closed", "PASS", false);
        } catch (Exception e) {
            reportStep("Unexpected error occurred in Browser", "FAIL", false);
        }
    }

    @Override
    public long takeSnap() {
        return 0;
    }
}

