package accion;

import common.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManejandoAlerts2Test {

    private static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private WebDriver driver = null;

    @BeforeEach
    public void setUp() {
        driver = Configuration.createChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    @Order(1)
    @DisplayName("Test JavaScript Alert")
    public void testJsAlert() {
        String expectedAlertText = "I am a JS Alert";
        String expectedAcceptResult = "You successfully clicked an alert";

        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();

        assertEquals(expectedAlertText, driver.switchTo().alert().getText(),
                "Verifico texto del alert");

        driver.switchTo().alert().accept();

        assertEquals(expectedAcceptResult, driver.findElement(By.id("result")).getText(),
                "Verifico resultado al pulsar Aceptar");
    }

    @Test
    @Order(2)
    @DisplayName("Test click Accept button on JavaScript Confirm")
    public void testAcceptJsConfirm() {
        String expectedAlertText = "I am a JS Confirm";
        String expectedAcceptResult = "You clicked: Ok";

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();

        assertEquals(expectedAlertText, driver.switchTo().alert().getText(),
                "Verifico texto del alert");

        driver.switchTo().alert().accept();

        assertEquals(expectedAcceptResult, driver.findElement(By.id("result")).getText(),
                "Verifico resultado al pulsar Aceptar");
    }

    @Test
    @Order(3)
    @DisplayName("Test click Cancel button on JavaScript Confirm")
    public void testCancelJsConfirm() {
        String expectedAlertText = "I am a JS Confirm";
        String expectedAcceptResult = "You clicked: Cancel";

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();

        assertEquals(expectedAlertText, driver.switchTo().alert().getText(),
                "Verifico texto del alert");

        driver.switchTo().alert().dismiss();

        assertEquals(expectedAcceptResult, driver.findElement(By.id("result")).getText(),
                "Verifico resultado al pulsar Aceptar");
    }

    @Test
    @Order(4)
    @DisplayName("Test click Accept button with input text on JavaScript Prompt")
    public void testAcceptWithInputTextOnInputJSPrompt() {
        String inputText = "This is a test";
        String expectedAlertText = "I am a JS prompt";
        String expectedAcceptResult = "You entered: " + inputText;

        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();

        assertEquals(expectedAlertText, driver.switchTo().alert().getText(),
                "Verifico texto del alert");

        driver.switchTo().alert().sendKeys(inputText);
        driver.switchTo().alert().accept();

        assertEquals(expectedAcceptResult, driver.findElement(By.id("result")).getText(),
                "Verifico resultado al pulsar Aceptar");
    }

    @Test
    @Order(5)
    @DisplayName("Test click Accept button with no input text on JavaScript Prompt")
    public void testAcceptWithNoInputTextOnInputJSPrompt() {
        String expectedAlertText = "I am a JS prompt";
        String expectedAcceptResult = "You entered: ";

        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();

        assertEquals(expectedAlertText, driver.switchTo().alert().getText(),
                "Verifico texto del alert");

        driver.switchTo().alert().accept();

        assertEquals(expectedAcceptResult.trim(), driver.findElement(By.id("result")).getText(),
                "Verifico resultado al pulsar Aceptar");
    }

    @Test
    @Order(6)
    @DisplayName("Test click Cancel button with input text on JavaScript Prompt")
    public void testCancelWithInputTextOnInputJSPrompt() {
        String inputText = "This is a test";
        String expectedAlertText = "I am a JS prompt";
        String expectedAcceptResult = "You entered: null";

        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();

        assertEquals(expectedAlertText, driver.switchTo().alert().getText(),
                "Verifico texto del alert");

        driver.switchTo().alert().sendKeys(inputText);
        driver.switchTo().alert().dismiss();

        assertEquals(expectedAcceptResult, driver.findElement(By.id("result")).getText(),
                "Verifico resultado al pulsar Aceptar");
    }

    @Test
    @Order(7)
    @DisplayName("Test click Cancel button with no input text on JavaScript Prompt")
    public void testCancelWithNoInputTextOnInputJSPrompt() {
        String expectedAlertText = "I am a JS prompt";
        String expectedAcceptResult = "You entered: null";

        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();

        assertEquals(expectedAlertText, driver.switchTo().alert().getText(),
                "Verifico texto del alert");

        driver.switchTo().alert().dismiss();

        assertEquals(expectedAcceptResult, driver.findElement(By.id("result")).getText(),
                "Verifico resultado al pulsar Aceptar");
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
