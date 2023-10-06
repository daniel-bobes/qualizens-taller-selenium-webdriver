package accion;

import common.ClaseBase1;
import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class IngresarVerificarTextoTest extends ClaseBase1 {

    @Test
    public void testIngresarUserName() {
        String expectedUser = Configuration.USER;

        WebElement element = driver.findElement(By.id("user_login"));

        assertTrue(element.isEnabled(),
                "Verifico que el username esta habilitado");

        element.sendKeys(expectedUser);

        String currentUser = element.getAttribute("value");
        assertEquals(expectedUser, currentUser,
                "Verifico que el usuario ingresado es igual al actual");

    }
}
