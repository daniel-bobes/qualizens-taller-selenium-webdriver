package accion;

import common.ClaseBase2;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class ControlSelectTest extends ClaseBase2 {

    @Test
    public void testSelectUsingClick() {
        this.getDriver().manage().window().maximize();
        this.getDriver().findElement(By.linkText("Settings")).click();
        this.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.id("blogname")));

        //Thread.sleep(3000);
        WebElement dropdown = this.getDriver().findElement(By.id("start_of_week"));
        dropdown.click();
        //Thread.sleep(3000);

        String expectedDay = "Wednesday";
        String xpathSelector = "//option[text()='" + expectedDay + "']";
        WebElement option = this.getDriver().findElement(By.xpath(xpathSelector));
        option.click();
        //Thread.sleep(3000);

        assertTrue(option.isSelected(),
                "Verifico que el elemento esta seleccionado");
        assertEquals(expectedDay, option.getText(),
                "verifico que el elemento seleccionado es el correcto");
    }

    @Test
    public void testSelectUsingSendKeys() {
        this.getDriver().manage().window().maximize();
        this.getDriver().findElement(By.linkText("Settings")).click();
        this.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.id("blogname")));

        //Thread.sleep(3000);
        WebElement dropDown = this.getDriver().findElement(By.id("start_of_week"));
        String expectedDay = "Wednesday";
        dropDown.sendKeys(expectedDay);
        //Thread.sleep(3000);

        String xpathSelector = "//option[text()='" + expectedDay + "']";
        WebElement option = this.getDriver().findElement(By.xpath(xpathSelector));
        assertTrue(option.isSelected(),
                "Verifico que el elemento esta seleccionado");
        assertEquals(expectedDay, option.getText(),
                "verifico que el elemento seleccionado es el correcto");
    }

    @Test
    public void testSelectUsingSelectByVisibleText() {
        this.getDriver().manage().window().maximize();
        this.getDriver().findElement(By.linkText("Settings")).click();
        this.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.id("blogname")));

        //Thread.sleep(3000);
        Select dropDown = new Select(this.getDriver().findElement(By.id("start_of_week")));
        String expectedDay = "Wednesday";
        dropDown.selectByVisibleText(expectedDay);
        //Thread.sleep(3000);

        String selectedDay = dropDown.getFirstSelectedOption().getText();
        assertEquals(expectedDay, selectedDay, "Verifico el día seleccionado");
        SeleniumUtils.printWebElementInfo("Select start of week", dropDown.getWrappedElement());

        System.out.println("Opciones del select:");
        for (WebElement element : dropDown.getOptions()) {
            System.out.println(
                    "\tOpción: " + element.getText()
                            + " (isSelected()? " + element.isSelected() + ")");
        }
    }
}
