package accion;

import common.ClaseBase2;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EjecutarJSTest extends ClaseBase2 {

    @Test
    public void test1() {
        JavascriptExecutor jsExec = (JavascriptExecutor) this.getDriver();

        jsExec.executeScript(
                "document.querySelector('#wp-admin-bar-site-name > a').click();"
        );

        getWait().until(
                ExpectedConditions.presenceOfElementLocated(By.linkText("User's blog")));

        getDriver().navigate().back();
    }

    @Test
    public void test2() {
        JavascriptExecutor jsExec = (JavascriptExecutor) this.getDriver();

        WebElement viewSiteLink = this.getDriver().findElement(
                By.cssSelector("#wp-admin-bar-site-name > a"));

        jsExec.executeScript("arguments[0].click();", viewSiteLink);

        getDriver().navigate().back();
    }

    @Test
    public void test3() {
        JavascriptExecutor jsExec = (JavascriptExecutor) this.getDriver();

        WebElement siteLink = (WebElement) jsExec.executeScript(
                "return document.querySelector('#wp-admin-bar-site-name > a')");

        siteLink.click();

        getWait().until(
                ExpectedConditions.presenceOfElementLocated(By.linkText("User's blog")));

        getDriver().navigate().back();
    }
}
