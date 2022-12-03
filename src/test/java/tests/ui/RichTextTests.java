package tests.ui;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RichTextPage;
import validation.ValidateRichText;

@Test
public class RichTextTests extends BaseTest {
    private RichTextPage richTextPage;
    private ValidateRichText validation = new ValidateRichText();

    @BeforeTest
    public void setUp() {
        super.setUp();
    }

    @AfterTest
    private void quit() {
        webDriver.quit();
    }

    @Test
    public void richTextTest() throws InterruptedException {
        richTextPage = new RichTextPage(webDriver);
        richTextPage.fillEditableForm("Automation ", "Test", " Example");
        validation.validateFormContent(richTextPage.getFormContent());
    }
}