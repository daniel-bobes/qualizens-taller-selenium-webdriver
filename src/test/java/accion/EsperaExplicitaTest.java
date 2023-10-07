package accion;

import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;


public class EsperaExplicitaTest {

    @Test
    public void test() {
        WebDriver driver = Configuration.createChromeDriver();

        // Selenium 3
        //WebDriverWait wait = new WebDriverWait(driver, 60);

        // Selenium 4
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.get(Configuration.ADMIN_URL);

        WebElement username = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("log")));
        username.sendKeys(Configuration.USER);
        assertEquals(
                Configuration.USER, username.getAttribute("value"), "verifico usuario");

        WebElement password = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("pwd")));
        password.sendKeys(Configuration.PASS);
        assertEquals(Configuration.PASS, password.getAttribute("value"), "Verifico password");

        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("wp-submit")));
        submitButton.click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[text()='Log Out']")));

        WebElement logout = driver.findElement(By.xpath("//a[text()='Log Out']"));
        System.out.println(logout.getAttribute("href"));
        driver.get(logout.getAttribute("href"));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(text(), 'logged out.')]")));

        driver.quit();
    }
}
