package accion;

import common.ClaseBase2;
import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TakeScreenshotsWithSeleniumTest extends ClaseBase2 {

    @Test
    public void testTakingScreenshot() {
        TakesScreenshot camera = (TakesScreenshot) this.getDriver();

        File sFile = camera.getScreenshotAs(OutputType.FILE);

        String path = String.format("%s%s-%s.png",
                Configuration.SCREENSHOT_DIR, "captura", System.currentTimeMillis());

        boolean fileRenamed = sFile.renameTo(new File(path));
        assertTrue(fileRenamed);
    }

    @Test
    public void takeElementScreenshot() throws NoSuchMethodException {
        WebElement welcomePanel = this.getDriver().findElement(By.id("wp-version-message"));
        File source = welcomePanel.getScreenshotAs(OutputType.FILE);
        String path = String.format("%s%s-%s.png",
                Configuration.SCREENSHOT_DIR, "captura", System.currentTimeMillis());
        File dest = new File(path);
        //FileUtils.copyFile(source, dest);
        boolean fileRenamed = source.renameTo(dest);
        assertTrue(fileRenamed);
    }

    @Test
    public void takeFullPageScreenshot() {
        this.getDriver().findElement(By.linkText("Posts")).click();
        this.getDriver().findElement(By.linkText("Add New")).click();
        WebElement publish = this.getWait().until(
                ExpectedConditions.presenceOfElementLocated(By.id("publish"))
        );
        File source = ((FirefoxDriver) this.getDriver()).getFullPageScreenshotAs(OutputType.FILE);
        String path = String.format("%s%s-%s.png",
                Configuration.SCREENSHOT_DIR, "captura", System.currentTimeMillis());
        File dest = new File(path);
        boolean fileRenamed = source.renameTo(dest);
        assertTrue(fileRenamed);
    }

}
