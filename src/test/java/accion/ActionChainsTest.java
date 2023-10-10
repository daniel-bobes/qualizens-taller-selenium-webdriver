package accion;

import common.ClaseBase2;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionChainsTest extends ClaseBase2 {

    @Test
    public void testMoverAndClick() {
        WebElement menuBar = this.getDriver().findElement(By.id("wp-admin-bar-site-name"));

        Actions builder = new Actions(this.getDriver());
        builder.moveToElement(menuBar)
                .pause(1000)
                .click(getDriver().findElement(By.id("wp-admin-bar-view-site")));

        Action compAction = builder.build();
        compAction.perform();

        this.getWait().until(
                ExpectedConditions.presenceOfElementLocated(By.linkText("User's blog"))
        );
    }
}
