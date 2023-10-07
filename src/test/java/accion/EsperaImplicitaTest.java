package accion;

import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class EsperaImplicitaTest {

    @Test
    public void test() {
        WebDriver driver = Configuration.createChromeDriver();

        // Selenium 3
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(Configuration.ADMIN_URL);

        WebElement username = driver.findElement(By.name("log"));
        username.sendKeys(Configuration.USER);

        WebElement password = driver.findElement(By.name("pwd"));
        password.sendKeys(Configuration.PASS);
        password.submit();

        boolean cargaDashboard = driver.findElement(By.id("wpadminbar")).isDisplayed();
        assertTrue(cargaDashboard, "Verifico carga de dashboard");

        WebElement logout = driver.findElement(By.xpath("//a[text()='Log Out']"));
        driver.get(logout.getAttribute("href"));

        WebElement logoutMessage = driver.findElement(By.xpath("//p[contains(text(), 'logged out.')]"));
        assertTrue(logoutMessage.isDisplayed(), "Verifico visibilidad del mensaje logout");

        driver.quit();
    }

}
