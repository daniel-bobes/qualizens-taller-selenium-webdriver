package accion;

import common.ClaseBase2;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class ManejandoFramesTest extends ClaseBase2 {

    @Test
    public void test() {
        this.getDriver().findElement(By.linkText("Posts")).click();
        this.getDriver().findElement(By.linkText("Add New")).click();

        WebElement publish = this.getWait().until(
                ExpectedConditions.presenceOfElementLocated(By.id("publish"))
        );

        String title = "Título de prueba";
        WebElement titleBox = this.getDriver().findElement(By.id("title"));
        titleBox.sendKeys(title);

        assertEquals(title, titleBox.getAttribute("value"),
                "Verifico que la casilla del titulo se haya completado");

        this.getDriver().switchTo().frame("content_ifr");

        String text = "Texto de prueba";
        WebElement content = this.getDriver().findElement(By.id("tinymce"));
        content.sendKeys(text);
        assertEquals(text, content.getText(), "Verifico el texto del frame");

        this.getDriver().switchTo().defaultContent();

        this.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.className("edit-slug")));

        publish.click();

    }
}
