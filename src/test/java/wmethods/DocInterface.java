package wmethods;

import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

public interface DocInterface {

    /**
     * This method will launch the chrome browser and maximize the browser and set the wait for 30 seconds
     * and load the url
     * @author Dinesh - Pramati
     * @param browser - This will load the specified browser
     * @throws MalformedURLException */
    public void startApp(String browser, boolean bReturns) throws MalformedURLException;

    /**This method is used to find the element and pass the values:
     * @Param locator -  The locator by which the element to be found
    * @param locValue - The locator value by which the element to be found
     * @throws org.openqa.selenium.NoSuchElementException  */
    public WebElement locateElement(String locator, String locValue );
    /**
     * This method will locate the element using id
     * @param locValue - The locator value by which the element to be found
     * @author Dinesh - Pramati
     * @throws org.openqa.selenium.NoSuchElementException
     */
    public WebElement locateElement(String locValue) ;

    /**
     * This method will enter the value in the given text field
     * @param ele   - The Webelement (text field) in which the data to be entered
     * @param data  - The data to be sent to the webelement
     * @author Dinesh - Pramati
     * @throws org.openqa.selenium.ElementNotVisibleException		 *
     */
    public void typeInp(WebElement ele, String data) ;

    /**
     * This method is used to click the element and take snapshot
     * @param ele - The webelement (button/link/webelement) to be clicked.
     * @author Dinesh - Pramati
     * */
    public WebElement click(WebElement ele);

    /**
     * This method will get the text of the element
     * @param ele   - The Webelement (button/link/element) in which text to be retrieved
     * @author Dinesh - Pramati
     */
    public String getText(WebElement ele);

    /**
     * This method will close  particular browser
     * @author Dinesh - Pramati
     */
    public void closeBrowser();

    /**
     * This method will close all the browsers
     * @author Dinesh - Pramati
     */
    public void closeAllBrowsers();
}