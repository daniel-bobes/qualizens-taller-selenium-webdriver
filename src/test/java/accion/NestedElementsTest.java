package accion;

import common.ClaseBase2;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NestedElementsTest extends ClaseBase2 {

    @Test
    public void test01() {
        this.getDriver().findElement(By.linkText("Posts")).click();
        this.getDriver().findElement(By.linkText("Categories")).click();

        WebElement tabla = this.getDriver().findElement(By.className("wp-list-table"));
        WebElement primerCheckbox = tabla.findElement(By.name("delete_tags[]"));
        SeleniumUtils.printWebElementInfo("Primer checkbox", primerCheckbox);
        primerCheckbox.click();
        assertTrue(primerCheckbox.isSelected(), "Verifico checklist seleccionada");
    }

    @Test
    public void test02() {
        this.getDriver().findElement(By.linkText("Posts")).click();
        this.getDriver().findElement(By.linkText("Categories")).click();

        WebElement tabla = this.getDriver().findElement(By.className("wp-list-table"));

        List<WebElement> checkboxes = tabla.findElements(By.name("delete_tags[]"));

        WebElement firstCheckbox = checkboxes.get(0);
        SeleniumUtils.printWebElementInfo("Primer checkbox", firstCheckbox);
        firstCheckbox.click();
        assertTrue(firstCheckbox.isSelected(), "Verifico checklist seleccionada");
    }

    @Test
    public void test03() {
        this.getDriver().findElement(By.linkText("Posts")).click();
        this.getDriver().findElement(By.linkText("Categories")).click();

        WebElement tabla = this.getDriver().findElement(By.className("wp-list-table"));
        List<WebElement> childs = tabla.findElements(By.cssSelector("*"));

        for (WebElement child : childs) {
            System.out.println("\tChild: " + child.getTagName()
                    + "\n\t\t" + child.getAttribute("outerHTML"));
        }
    }
}
