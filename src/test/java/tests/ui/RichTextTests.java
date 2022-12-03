package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RichTextPage;
import validation.ValidateRichText;

@Test
public class RichTextTests {
    private WebDriver webDriver;
    private RichTextPage richTextPage;
    private ValidateRichText validation = new ValidateRichText();

    @BeforeTest
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
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