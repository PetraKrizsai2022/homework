package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InventoryPage {
    private final WebDriver webDriver;
    private final String URL = "https://www.saucedemo.com/inventory.html";

    private final By usernameBy = By.id("user-name");
    private final By passwordBy = By.id("password");
    private final By loginBy = By.id("login-button");
    private final By sauceLabsBackPackBy = By.id("add-to-cart-sauce-labs-backpack");
    private final By sauceLabsFleeceJackedBy = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By shoppingCartLinkBy = By.className("shopping_cart_link");
    private final By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    private final By checkoutBy = By.id("checkout");
    private final By firstNameBy = By.id("first-name");
    private final By lastNameBy = By.id("last-name");
    private final By postalCodeBy = By.id("postal-code");
    private final By continueBy = By.id("continue");
    private final By finishBy = By.id("finish");
    private final By completeHeaderBy = By.className("complete-header");
    private final By errorButtonBy = By.cssSelector("h3[data-test='error']");
    private final By footerBy = By.className("footer_copy");

    public InventoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }

    public void login(String username, String password) {
        WebElement usernameElement = webDriver.findElement(usernameBy);
        WebElement passwordElement = webDriver.findElement(passwordBy);

        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);

        clickLoginButton();
    }

    public void clickLoginButton() {
        WebElement loginElement = webDriver.findElement(loginBy);
        loginElement.click();
    }

    public void addToCartSauceLabsBackPack() {
        WebElement element = webDriver.findElement(sauceLabsBackPackBy);
        element.click();
    }

    public void addToCartSauceLabsFleeceJacket() {
        WebElement element = webDriver.findElement(sauceLabsFleeceJackedBy);
        element.click();
    }

    public String getShoppingCartBadgeBy() {
        WebElement element = webDriver.findElement(shoppingCartBadgeBy);
        Actions action = new Actions(webDriver);
        action.moveToElement(element);
        return element.getText();
    }

    public void clickShoppingCartLink() {
        WebElement element = webDriver.findElement(shoppingCartLinkBy);
        element.click();
    }

    public void clickCheckout() {
        WebElement element = webDriver.findElement(checkoutBy);
        element.click();
    }

    public void fillFirstName(String firstName) {
        WebElement element = webDriver.findElement(firstNameBy);
        element.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        WebElement element = webDriver.findElement(lastNameBy);
        element.sendKeys(lastName);
    }

    public void fillPostalCode(String postalCode) {
        WebElement element = webDriver.findElement(postalCodeBy);
        element.sendKeys(postalCode);
    }

    public void clickContinue() {
        WebElement element = webDriver.findElement(continueBy);
        element.click();
    }

    public void clickFinish() {
        WebElement element = webDriver.findElement(finishBy);
        element.click();
    }

    public String getCompleteHeader() {
        WebElement element = webDriver.findElement(completeHeaderBy);
        return element.getText();
    }

    public String getErrorButtonText() {
        WebElement element = webDriver.findElement(errorButtonBy);
        return element.getText();
    }

    public String getFooterText() {
        WebElement element = webDriver.findElement(footerBy);
        return element.getText();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
     }
}
