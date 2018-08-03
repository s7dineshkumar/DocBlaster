package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;
import org.openqa.selenium.support.PageFactory;

import java.io.InterruptedIOException;

public class IndexPage extends BaseTest{
    //full username:
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle']")
    public WebElement indexToggle;

    //Status Facets:
    //@FindBy(how=How.XPATH,using = "(//label[@data-colapse-target='status_facets']/following::i[@class='fa fa-angle-down'])[1]")
    @FindBy(how = How.CSS, using = "input[id=check-all-status]")
    public WebElement statusFacets;

    @FindBy(how = How.XPATH, using = "//div[@data-check-group='status_facet']/div/label/input[@value='Pending']")
    public WebElement pending;

    @FindBy(how = How.XPATH, using = "//div[@data-check-group='status_facet']/div/label/input[@value='Editing']")
    public WebElement editing;
    @FindBy(how = How.XPATH, using = "//div[@data-check-group='status_facet']/div/label/input[@value='Supervisor Accepted']")
    public WebElement supAccepted;

    @FindBy(how = How.ID, using = "check-all-document-types")
    public WebElement docType;
    @FindBy(how = How.XPATH, using = "//div[@data-check-group='doc_chck_all']/div/label/input[@value='ptab_final_decision']")
    public WebElement ptabFD;
    //Apply:
    @FindBy(how = How.ID, using = "facet-apply-button")
    public WebElement apply;
    //Edit the document:
    @FindBy(how = How.XPATH, using = "(//a[@class='btn btn-primary btn-custom doc-edit-action'])[2]")
    public WebElement editDoc;

    //Assertion to check the logged in username:
    public String index() {
        return indexToggle.getText();
    }
    public void docResults() throws InterruptedException {
        statusFacets.click();
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-check-group='status_facet']/div/label/input[@value='Pending']")));
        pending.click();
        editing.click();
        supAccepted.click();
        docType.click();
        WebDriverWait wait1 = new WebDriverWait(getDriver(),10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-check-group='doc_chck_all']/div/label/input[@value='ptab_final_decision']")));
        ptabFD.click();
        apply.click();
        editDoc.click();
    }

}