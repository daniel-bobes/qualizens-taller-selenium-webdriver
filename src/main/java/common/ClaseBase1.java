package common;

import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ClaseBase1 {
    protected static WebDriver driver = null;

    @BeforeAll
    public static void launchBrowser() throws Exception {
        driver = Configuration.createChromeDriver();
        driver.get(Configuration.ADMIN_URL);
        Thread.sleep(2000);
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}
