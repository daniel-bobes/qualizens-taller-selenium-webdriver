package pagina;

import common.ClaseBase1;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EstrategiasIdentificacionTest extends ClaseBase1 {

    @Test
    public void testHeaderLevel1ByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        SeleniumUtils.printWebElementInfo("Header Level 1", element);
    }

    @Test
    public void testUsernameFieldById() {
        WebElement element = driver.findElement(By.id("user_pass"));
        SeleniumUtils.printWebElementInfo("Campo de contraseña", element);
    }

    @Test
    public void testInputByClassName() {
        WebElement element = driver.findElement(By.className("input"));
        SeleniumUtils.printWebElementInfo("Campo de texto", element);
    }

    @Test
    public void testPasswordFieldByName() {
        WebElement element = driver.findElement(By.name("pwd"));
        SeleniumUtils.printWebElementInfo("Campo de texto", element);
    }

    @Test
    public void testLoginButtonByClassName() {
        WebElement element = driver.findElement(By.className("button-primary"));
        SeleniumUtils.printWebElementInfo("Botón Log In", element);
    }

}
