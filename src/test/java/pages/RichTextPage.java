package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class RichTextPage {
    private final WebDriver webDriver;
    private final String URL = "https://onlinehtmleditor.dev";

    private final By boldButtonBy = By.cssSelector("a[id='cke_19']");
    private final By underLineButtonBy = By.cssSelector("a[id='cke_21']");
    private final By editableFormBy = By.xpath("//body[@role='textbox']/p");

    public RichTextPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }

    public void fillEditableForm(String text1, String text2, String text3) throws InterruptedException {
        Thread.sleep(3000);
        WebElement boldButton = webDriver.findElement(boldButtonBy);
        WebElement underLineButton = webDriver.findElement(underLineButtonBy);

        //Bold text
        boldButton.click();

        webDriver.switchTo().frame(0);

        WebElement form = webDriver.findElement(editableFormBy);
        form.sendKeys(text1);

        //Underline text
        webDriver.switchTo().defaultContent();
        underLineButton.click();
        boldButton.click();

        webDriver.switchTo().frame(0);

        form.sendKeys(text2);

        //Normal text
        webDriver.switchTo().defaultContent();
        underLineButton.click();

        webDriver.switchTo().frame(0);
        form.sendKeys(text3);
    }

    public Map<String, String> getFormContent() {
        Map<String, String> formContent = new HashMap<>();

        WebElement form = webDriver.findElement(editableFormBy);
        formContent.put("text", form.getText());

        WebElement boldContent = webDriver.findElement(By.xpath("//body[@role='textbox']/p/strong"));
        formContent.put("boldText", boldContent.getText());

        WebElement underLineContent = webDriver.findElement(By.xpath("//body[@role='textbox']/p/u"));
        formContent.put("underLineText", underLineContent.getText());

        return formContent;
    }
}
