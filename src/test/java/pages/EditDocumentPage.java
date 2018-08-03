package pages;

import org.omg.CORBA.INITIALIZE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

public class EditDocumentPage extends BaseTest {

   /* //Request for Adverse Judgement
    @FindBy(how = How.XPATH, using = "//li/span[text()=' Request for Adverse Judgement']")
    public WebElement reqAdvJudgment;*/

    //Add Request:
    @FindBy(how = How.XPATH, using = "//div/a[@data-association='adverse_judgment_request']")
    public WebElement addRequest;

    /*//Requesting Party Name:
    @FindBy(how = How.CSS, using = "div.requesting_party_wrapper label[for='doc_request_for_adverse_judgment_1532607447309_requesting_party_info_1532607452307_aj_party_id']")
    public WebElement reqPartyName;

    //Requesting party Type:
    @FindBy(how = How.CSS, using = "div.requesting_party_wrapper label[for='doc_request_for_adverse_judgment_1532607447309_requesting_party_info_1532607452307_aj_party_type']")
    public WebElement reqPartyType;

    //Check requesting party name:
    public String partyName() {
        return reqPartyName.getText();
    }
    //Check requesting party type:
    public String partyType() {
        return reqPartyName.getText();
    }*/

    //Select duplicate party name:
    @FindBy(how = How.XPATH, using = "//select[@id=\"doc_request_for_adverse_judgment_1532607447309_requesting_party_info_1532607452307_aj_party_id\"]")
    public WebElement selectPartyName1;

    @FindBy(how=How.XPATH,using = "//div/a[@data-association='1532607447309_requesting_party']")
    public WebElement  addRequestingParty;

    //Select duplicate party name:
    @FindBy(how = How.XPATH, using = "//select[@id=\"doc_request_for_adverse_judgment_1532607447309_requesting_party_info_1532607452307_aj_party_id\"]")
    public WebElement selectPartyName2;

    @FindBy(how=How.CLASS_NAME,using = "btn btn-primary doc-actions-btn doc-save-changes-button")
    public WebElement saveChanges;

    public void adverseJudgmentSection() throws Exception {
        /*WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/span[text()=' Request for Adverse Judgement']")));
        reqAdvJudgment.click();*/
        WebDriverWait wait1 = new WebDriverWait(getDriver(),10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@data-association='adverse_judgment_request']")));
        addRequest.click();
        Select selParty1 = new Select(selectPartyName1);
        selParty1.selectByIndex(0);
        addRequestingParty.click();
        Select selParty2 = new Select(selectPartyName2);
        selParty2.selectByIndex(0);
        saveChanges.click();
        getDriver().switchTo().alert().accept();
    }
}
