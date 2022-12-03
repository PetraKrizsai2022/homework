package tests.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pojo.CredentialDto;
import validation.ValidateInventoryTest;

import java.io.File;
import java.io.IOException;

@Test
public class InventoryTests {
    private final File credentialFile = new File("src/test/resources/credential.json");
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ValidateInventoryTest validation = new ValidateInventoryTest();

    private WebDriver webDriver;
    private InventoryPage inventoryPage;
    private String username;
    private String password;

    @BeforeTest
    private void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        setCredentials();
    }

    private void setCredentials() throws IOException {
        CredentialDto credentialDto = objectMapper.readValue(credentialFile, CredentialDto.class);
        username = credentialDto.getUsername();
        password = credentialDto.getPassword();
    }

    @AfterTest
    private void quit() {
        webDriver.quit();
    }

    @Test
    public void purchaseProcessFlowTest() {
        inventoryPage = new InventoryPage(webDriver);
        inventoryPage.login(username, password);
        inventoryPage.addToCartSauceLabsBackPack();
        inventoryPage.addToCartSauceLabsFleeceJacket();

        validation.validateCartBadge(inventoryPage.getShoppingCartBadgeBy());

        inventoryPage.clickShoppingCartLink();

        inventoryPage.clickCheckout();
        inventoryPage.fillFirstName(username);
        inventoryPage.fillLastName(username);
        inventoryPage.fillPostalCode("1111");

        inventoryPage.clickContinue();
        inventoryPage.clickFinish();

        validation.validateCompleteHeader(inventoryPage.getCompleteHeader());
    }

    @Test
    public void verifyErrorMessagesTest() {
        inventoryPage = new InventoryPage(webDriver);
        inventoryPage.clickLoginButton();

        validation.validateErrorMessage(inventoryPage.getErrorButtonText());

        inventoryPage.login("standard_user", "secret_sauce");
        inventoryPage.scrollDown();

        validation.validateFooter(inventoryPage.getFooterText());
    }
}
