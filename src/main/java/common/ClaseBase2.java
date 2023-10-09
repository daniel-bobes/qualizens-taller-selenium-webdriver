package common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class ClaseBase2 {
    private WebDriver driver = null;
    private WebDriverWait wait = null;

    @BeforeEach
    public void login() {
        driver = Configuration.createChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get(Configuration.ADMIN_URL);

        System.out.println(this.getDriver().getTitle()
                + " (" + this.getDriver().getCurrentUrl() + ")");
        System.out.println("Window handle: " + this.getDriver().getWindowHandle());

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("log"))
        );
        username.sendKeys(Configuration.USER);
        assertEquals(Configuration.USER, username.getAttribute("value"), "Verifico Uusuario");

        WebElement password = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("pwd"))
        );
        password.sendKeys(Configuration.PASS);
        assertEquals(Configuration.PASS, password.getAttribute("value"), "Verifico password");

        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("wp-submit"))
        );
        submitButton.click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[text()='Log Out']")
                )
        );
    }

    @AfterEach
    public void logout() {
        WebElement logout = driver.findElement(By.xpath("//a[text()='Log Out']"));
        driver.get(logout.getAttribute("href"));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(), 'logged out.')]")
                )
        );

        driver.quit();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected WebDriverWait getWait() {
        return this.wait;
    }

}
