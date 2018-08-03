package testcases;

import org.testng.annotations.Test;
import pages.IndexPage;
import java.io.IOException;

public class DocumentIndexTest extends BaseFuncTest {

    IndexPage iPage = (IndexPage) getPage(IndexPage.class);

    @Test(priority = 1)
    public void documentDetails() throws InterruptedException {
        iPage.docResults();
    }
}
