package pagina;

import common.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaConFixturesTest {

    WebDriver driver = null;

    @BeforeAll
    public static void suiteSetup() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("BeforeEach");
        driver = Configuration.createChromeDriver();
    }

    @Test
    public void testPageTitle() {
        System.out.println("Test");
        driver.get(Configuration.ADMIN_URL);
        String expectedTitle = "Log In ‹ User's blog — WordPress"; // "Log In ‹ User's blog — WordPress"
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle,
                "El título de la página no es el esperado");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("AfterEach");
        driver.quit();
    }

    @AfterAll
    public static void suiteTearDown() {
        System.out.println("AfterAll");
    }
}
