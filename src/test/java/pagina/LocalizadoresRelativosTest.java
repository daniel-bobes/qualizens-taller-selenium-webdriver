package pagina;

import common.ClaseBase1;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LocalizadoresRelativosTest extends ClaseBase1 {

    @Test
    public void testAboveRelativeLocator() {
        WebElement userNameInput = driver.findElement(By.name("log"));
        SeleniumUtils.printWebElementInfo("Usernama input", userNameInput);

        WebElement userNameLabel = driver.findElement(with(By.tagName("label")).above(userNameInput));
        String expectedText = "Username or Email Address";
        String currentText = userNameLabel.getText();
        assertEquals(expectedText, currentText,
                "Verifico que hemos encontrado el labol usando un localizador relativo");
        SeleniumUtils.printWebElementInfo("Username label", userNameLabel);
    }

    @Test
    public void testBelowRelativeLocator() {
        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='user_pass']"));
        SeleniumUtils.printWebElementInfo("Password label", passwordLabel);
        String expectedText = "Password";
        String currentText = passwordLabel.getText();
        assertEquals(expectedText, currentText,
                "Verifico que hemos seleccionado el labol password");

        WebElement passwordInput = driver.findElement(with(By.cssSelector("input[class]")).below(passwordLabel));
        String expectedId = "user_pass";
        String currentId = passwordInput.getAttribute("id");
        assertEquals(expectedId, currentId,
                "Verifico que hemos encontrado el input pasword");
        SeleniumUtils.printWebElementInfo("Password input", passwordInput);
    }

    @Test
    public void testNearRelativeLocator() {
        WebElement rememberMeLabel = driver.findElement(By.cssSelector("label[for='rememberme']"));
        SeleniumUtils.printWebElementInfo("Remember Me label", rememberMeLabel);
        String expectedText = "Remember Me";
        String currentText = rememberMeLabel.getText();
        assertEquals(expectedText, currentText,
                "Verifico que hemos seleccionado el label Remember Me");

        WebElement rememberMeInput = driver.findElement(with(By.cssSelector("input")).near(rememberMeLabel));
        String expectedId = "rememberme";
        String currentId = rememberMeInput.getAttribute("id");
        assertEquals(expectedId, currentId,
                "Verifico que hemos encontrado el input remember me");
        SeleniumUtils.printWebElementInfo("Remember me input", rememberMeInput);
    }

    @Test
    public void testToLeftOfRelativeLocator() {
        WebElement rememberMeLabel = driver.findElement(By.cssSelector("label[for='rememberme']"));
        SeleniumUtils.printWebElementInfo("Remember Me label", rememberMeLabel);
        String expectedText = "Remember Me";
        String currentText = rememberMeLabel.getText();
        assertEquals(expectedText, currentText,
                "Verifico que hemos seleccionado el label Remember Me");

        WebElement rememberMeInput = driver.findElement(with(By.cssSelector("input")).toLeftOf(rememberMeLabel));
        String expectedId = "rememberme";
        String currentId = rememberMeInput.getAttribute("id");
        assertEquals(expectedId, currentId,
                "Verifico que hemos encontrado el input remember me");
        SeleniumUtils.printWebElementInfo("Remember me input", rememberMeInput);
    }

    @Test
    public void testToRightOfRelativeLocator() {
        WebElement rememberMeInput = driver.findElement(By.id("rememberme"));
        SeleniumUtils.printWebElementInfo("Remember Me input", rememberMeInput);

        String expectedId = "rememberme";
        String currentId = rememberMeInput.getAttribute("id");
        assertEquals(expectedId, currentId,
                "Verifico que hemos encontrado el input remember me");

        WebElement rememberMeLabel = driver.findElement(with(By.tagName("label")).toRightOf(rememberMeInput));
        String expectedText = "Remember Me";
        String currentText = rememberMeLabel.getText();
        assertEquals(expectedText, currentText,
                "Verifico que hemos seleccionado el label Remember Me");
        SeleniumUtils.printWebElementInfo("Remember me label", rememberMeLabel);
    }
}
