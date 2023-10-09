package accion;

import common.ClaseBase2;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManejandoAlertasTest extends ClaseBase2 {

    @Test
    public void testBorrarImagen() {
        this.getDriver().findElement(By.linkText("Media")).click();

        this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("posts-filter")));

        List<WebElement> checkboxes = this.getDriver().findElements(By.name("media[]"));
        checkboxes.get(0).click();

        this.getDriver().findElement(By.name("action")).click();

        Select bulkActions = new Select(this.getDriver().findElement(By.id("bulk-action-selector-top")));
        bulkActions.selectByValue("delete");

        this.getDriver().findElement(By.id("doaction")).click();

        System.out.println(this.getDriver().switchTo().alert().getText());
        String expectedText = """
                You are about to permanently delete these items from your site.
                This action cannot be undone.
                'Cancel' to stop, 'OK' to delete.""";
        String currentText = this.getDriver().switchTo().alert().getText();
        assertEquals(expectedText, currentText, "Verifico el texto del alert");
        this.getDriver().switchTo().alert().accept();
    }

}
