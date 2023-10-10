package accion;

import common.ClaseBase2;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

public class InteraccionConTecladoTest extends ClaseBase2 {

    @Test
    public void test1() {
        String titulo = "Ejemplo";
        WebElement postTitle = getDriver().findElement(By.name("post_title"));
        postTitle.sendKeys(Keys.chord(Keys.SHIFT, titulo));
        assertEquals(titulo.toUpperCase(), postTitle.getAttribute("value"),
                "Verifico texto en mayúscula");
        postTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        postTitle.sendKeys(Keys.BACK_SPACE);
        assertEquals("", postTitle.getAttribute("value"),
                "Verifico borrado del texto");
    }

    @Test
    public void test1b() {
        String titulo = "Ejemplo";
        WebElement postTitle = getDriver().findElement(By.name("post_title"));
        postTitle.sendKeys(Keys.chord(Keys.SHIFT, titulo));
        SeleniumUtils.printWebElementInfo("Antes", postTitle);
        assertEquals(titulo.toUpperCase(), postTitle.getAttribute("value"),
                "Verifico texto en mayúscula");
        postTitle.clear();
        postTitle.sendKeys(titulo);
        SeleniumUtils.printWebElementInfo("Después", postTitle);
        assertEquals(titulo, postTitle.getAttribute("value"),
                "Verifico texto");
    }

    @Test
    public void test2() {
        String titulo = "Ejemplo";

        WebElement postTitle = getDriver().findElement(By.name("post_title"));

        // Contruct-build-perform en un solo paso
        Actions builder = new Actions(getDriver());
        builder.keyDown(Keys.SHIFT)
                .sendKeys(postTitle, titulo)
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
        assertEquals(titulo.toUpperCase(), postTitle.getAttribute("value"),
                "Verifico texto en mayúscula");


        // En 3 pasos
        builder = new Actions(getDriver());
        builder.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE);

        Action compAction = builder.build();
        compAction.perform();

        assertEquals("", postTitle.getAttribute("value"),
                "Verifico borrado del texto");

        // En 2 pasos
        builder = new Actions(getDriver());
        builder.sendKeys(postTitle, titulo);
        builder.perform();
        assertEquals(titulo, postTitle.getAttribute("value"),
                "Verifico texto");

    }


}
