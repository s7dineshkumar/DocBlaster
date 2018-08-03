package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import utils.ConfigUtil;

public class LoginPage{

        //username:
        @FindBy(how = How.XPATH,using="//input[@id='email']")
        public WebElement email;

        //password:
        @FindBy(how=How.CSS,using="input#password")
        public WebElement password;

        //click on SignIn:
        @FindBy(how=How.XPATH,using="//input[@value='Sign in']")
        public WebElement signIn;

    @BeforeClass
       public void login(String uname, String pwd )
       {
        email.sendKeys(uname);
        password.sendKeys(pwd);
        signIn.click();
        }

       public IndexPage signIn(){
           return new IndexPage();
        }

}
