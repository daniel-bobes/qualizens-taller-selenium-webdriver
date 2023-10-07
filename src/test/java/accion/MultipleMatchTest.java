package accion;

import common.ClaseBase2;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleMatchTest extends ClaseBase2 {

    @Test
    public void test() {
        this.getDriver().findElement(By.linkText("Posts")).click();
        this.getDriver().findElement(By.linkText("Categories")).click();

        List<WebElement> checkboxes = this.getDriver().findElements(By.name("delete_tags[]"));

        System.out.println("Hay " + checkboxes.size() + " checkboxes");

        /*
        for(WebElement checkbox: checkboxes){
            checkbox.click();
            assertTrue(checkbox.isSelected());
            SeleniumUtils.printWebElementInfo("Category", checkbox);
        }
        */

        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
            assertTrue(checkboxes.get(i).isSelected());
            SeleniumUtils.printWebElementInfo("Category", checkboxes.get(i));
        }

    }
}
