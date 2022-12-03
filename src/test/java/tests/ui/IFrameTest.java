package tests.ui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IFramePage;
import validation.ValidateIFrameTest;

@Test
public class IFrameTest extends BaseTest {
    private IFramePage iFramePage;
    private ValidateIFrameTest validation = new ValidateIFrameTest();

    @BeforeTest
    public void setUp() {
        super.setUp();
    }

    @AfterTest
    public void quit() {
        webDriver.quit();
    }

    @Test
    public void iFramePageTest() throws InterruptedException {
        iFramePage = new IFramePage(webDriver);
        iFramePage.clickAcceptAllButton();
        iFramePage.clickImageButton();

        validation.validateTitle(iFramePage.getTitle());

        iFramePage.close();

        iFramePage.hoverOnTestingMenuItem();
        iFramePage.clickSeleniumLink();
        iFramePage.clickDismissButton();
        iFramePage.clickConsentButton();
    }

}
