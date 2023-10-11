package accion;

import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class NavegacionSinEncabezadoTest {
    private final String expectedUsername = "tomsmith";
    private final String expectedPassword = "SuperSecretPassword!";
    private final String URL = "https://the-internet.herokuapp.com";
    private final String LOGIN_URL = URL + "/login";

    @Test
    public void test() {
        WebDriver driver = new HtmlUnitDriver(true);
        driver.get(LOGIN_URL);

        String expectedTitle = "Login Page";
        WebElement title = driver.findElement(By.tagName("h2"));
        assertEquals(expectedTitle, title.getText(), "El título no coincide");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(expectedUsername);
        assertEquals(expectedUsername, usernameField.getAttribute("value"),
                "El username no coincide");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(expectedPassword);
        assertEquals(expectedPassword, passwordField.getAttribute("value"),
                "El username no coincide");

        driver.findElement(By.tagName("button")).click();

        String expectedLogInMessage = "You logged into a secure area! ×";
        WebElement flashMessage = driver.findElement(By.id("flash"));
        assertEquals(expectedLogInMessage, flashMessage.getText(), "No coincide el mensaje de login");

        driver.findElement(By.linkText("Logout")).click();

        String expectedLogOutMessage = "You logged out of the secure area! ×";
        flashMessage = driver.findElement(By.id("flash"));
        assertEquals(expectedLogOutMessage, flashMessage.getText(), "No coincide el mensaje de logout");

        driver.quit();
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", Configuration.modifyIfWindows(Configuration.CHROME_DRIVER_PATH));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=old");
        //options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get(LOGIN_URL);
        String expectedTitle = "Login Page";
        WebElement title = driver.findElement(By.tagName("h2"));
        assertEquals(expectedTitle, title.getText(), "El título no coincide");
        driver.quit();
    }

    @Test
    public void test3() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get(LOGIN_URL);
        String expectedTitle = "Login Page";
        WebElement title = driver.findElement(By.tagName("h2"));
        assertEquals(expectedTitle, title.getText(), "El título no coincide");
        driver.quit();
    }


}
