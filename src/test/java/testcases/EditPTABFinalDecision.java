package testcases;

import javafx.scene.layout.Priority;
import org.testng.annotations.Test;
import pages.EditDocumentPage;
import pages.IndexPage;

public class EditPTABFinalDecision extends BaseFuncTest {

    IndexPage iPage = (IndexPage) getPage(IndexPage.class);
    EditDocumentPage ePage = (EditDocumentPage) getPage(EditDocumentPage.class);

    @Test  //(dependsOnMethods = "docResults")
    public void ptabFD() throws Exception {
       /* ePage.partyName();
        ePage.partyType();*/
       iPage.docResults();
        ePage.adverseJudgmentSection();
    }
}
