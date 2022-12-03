package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IFramePage;
import validation.ValidateIFrameTest;

import java.io.IOException;

@Test
public class IFrameTest {
    private WebDriver webDriver;
    private IFramePage iFramePage;
    private ValidateIFrameTest validation = new ValidateIFrameTest();

    @BeforeTest
    private void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
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
