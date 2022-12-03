package tests.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public abstract class BaseTest {
    protected WebDriver webDriver;
    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

}
