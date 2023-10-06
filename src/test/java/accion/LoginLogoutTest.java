package accion;

import common.ClaseBase1;
import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class LoginLogoutTest extends ClaseBase1 {

    @Test
    public void test() throws Exception {
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("log"));
        username.sendKeys(Configuration.USER);

        WebElement password = driver.findElement(By.name("pwd"));
        password.sendKeys(Configuration.PASS);
        password.submit();

        Thread.sleep(2000);

        boolean cargaDashboard = driver.findElement(By.id("wpadminbar")).isDisplayed();
        assertTrue(cargaDashboard, "Verifico carga de dashboard");

        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log Out']"));
        // logoutButton.click(); org.openqa.selenium.ElementNotInteractableException: element not interactable
        driver.get(logoutButton.getAttribute("href"));

        Thread.sleep(2000);

        String expectedMessage = "You are now logged out.";
        WebElement logoutMessage = driver.findElement(By.className("message"));
        assertTrue(logoutMessage.isDisplayed());
        String currentMessage = logoutMessage.getText();
        assertEquals(expectedMessage, currentMessage, "Verifico el mensaje de logout");
    }
}
