package pagina;

import common.Configuration;
import org.openqa.selenium.WebDriver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaBasicaTest {

    @Test
    public void testPageTitle() {
        WebDriver driver = Configuration.createChromeDriver();
        driver.get(Configuration.ADMIN_URL);

        String expectedTitle = "Log In ‹ User's blog — WordPress";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle,
                "El título de la página no es el esperado");

        driver.quit();
    }

}
