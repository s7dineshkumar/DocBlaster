package testcases;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ConfigUtil;

import java.io.IOException;

public class BaseFuncTest extends BaseTest {
    LoginPage lPage = (LoginPage) getPage(LoginPage.class);
    IndexPage lPage1 = (IndexPage) getPage(IndexPage.class);

    @BeforeClass(alwaysRun = true)
    public void startBrowserAndLogin() throws Exception {
        login();
    }

    /*@AfterClass(alwaysRun = true)
    public void closeBrowser() throws Exception{
        clearCachesAndQuit();
    }*/

    public void login() throws IOException {
        getDriver().get(ConfigUtil.get("URL"));
        System.out.println("Browser is launched successfully");
        //LoginPage lPage1 = new LoginPage();
        //Use this object for Page Factory model
        lPage.login(ConfigUtil.get("username"), ConfigUtil.get("password"));
        System.out.println("Application is successfully logged in");
        String actualResult = lPage1.index();
        //System.out.println(actualResult);
        Assert.assertEquals(actualResult.contains("Dinesh Sing"), true);

    }
}
