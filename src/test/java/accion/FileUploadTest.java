package accion;

import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class FileUploadTest {

    @Test
    public void testFileUplaod() {
        WebDriver driver = Configuration.createChromeDriver();

        String URL = "https://the-internet.herokuapp.com/upload";
        driver.get(URL);

        driver.manage().window().maximize();

        String expectedFileName = "Selenium.jpg";
        String path = System.getProperty("user.dir")
                + File.separator
                + "files"
                + File.separator
                + expectedFileName;

        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).submit();

        WebElement title = driver.findElement(By.tagName("h3"));
        String expectedTitle = "File Uploaded!";
        assertEquals(expectedTitle, title.getText(), "Verifico el título");

        WebElement message = driver.findElement(By.id("uploaded-files"));
        assertEquals(expectedFileName, message.getText(), "Verifico archivo subido");

        driver.quit();
    }
}
