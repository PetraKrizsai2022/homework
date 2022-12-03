package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IFramePage {
    private final WebDriver webDriver;
    private final String URL = "http://demo.guru99.com/test/guru99home";
    private final By imageLinkBy = By.tagName("a");
    private final By acceptAllButtonBy = By.id("save");
    private final By testingMenuItemBy = By.xpath("//*[@id=\"rt-header\"]/div/div[2]/div/ul/li[2]");
    private final By seleniumLinkBy = By.xpath("//*[@id=\"rt-header\"]/div/div[2]/div/ul/li[2]/div/div/ul/li[3]/a");
    private final By disMissButtonBy = By.xpath("//*[@id=\"dismiss-button\"]");
    private final By consentButtonBy = By.className("fc-button-label");



    public IFramePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public void clickImageButton() {
        webDriver.switchTo().frame("a077aa5e");
        WebElement element = webDriver.findElement(imageLinkBy);
        element.click();
    }

    public void clickAcceptAllButton() {
        webDriver.switchTo().frame("gdpr-consent-notice");
        WebElement element = webDriver.findElement(acceptAllButtonBy);
        element.click();
    }

    public String getTitle() {
        List<String> windowHandles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(windowHandles.get(1));
        return webDriver.getTitle();

    }

    public void close() {
        webDriver.close();
    }

    public void hoverOnTestingMenuItem() throws InterruptedException {
        List<String> windowHandles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(windowHandles.get(0));
        webDriver.switchTo().defaultContent();

        scrollUp();
        WebElement testingMenuItem = webDriver.findElement(testingMenuItemBy);

        Actions action = new Actions(webDriver);
        action.moveToElement(testingMenuItem).build().perform();

        Thread.sleep(1000);
    }

    public void clickSeleniumLink() {
        WebElement element = webDriver.findElement(seleniumLinkBy);
        element.click();
    }

    public void clickDismissButton() throws InterruptedException {
        webDriver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
        Thread.sleep(1000);

        WebElement nestedFrame = webDriver.findElement(By.id("ad_iframe"));
        webDriver.switchTo().frame(nestedFrame);

        WebElement element = webDriver.findElement(disMissButtonBy);
        element.click();
    }

    public void clickConsentButton() {
        webDriver.switchTo().defaultContent();
        WebElement element = webDriver.findElement(consentButtonBy);
        element.click();
    }
}
