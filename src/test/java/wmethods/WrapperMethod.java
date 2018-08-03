package wmethods;

import org.testng.annotations.*;
import utils.DataInputProvider;
import java.io.IOException;

public abstract class WrapperMethod extends DBMethods {

    public String browserName;
    public String dataSheetName;

    @BeforeSuite
    public void beforeSuite() {
        startResult();
    }

    @BeforeClass
    public void beforeClass() {
        startTestModule(testCaseName, testDescription);
    }

    @BeforeMethod
    public void beforeMethod() {
        test = startTestCase(testNodes);
        test = startTestCase(category);
        test = startTestCase(authors);
        startApp(browserName);
    }

    @AfterSuite
    public void afterSuite() {
        endResult();
    }

    @AfterTest
    public void afterTest() {

    }

    @AfterMethod
    public void afterMethod() {
        closeAllBrowsers();
    }

    @DataProvider(name = "fetchData")
    public Object[][] getData() {
        return DataInputProvider.getSheet(dataSheetName);
    }

}
