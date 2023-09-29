package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Configuration {

    public static String DRIVER_DIR = System.getProperty("user.dir")
            + File.separator
            + "drivers"
            + File.separator;
    public static String CHROME_DRIVER_PATH = DRIVER_DIR + "chromedriver";
    public static String GECKO_DRIVER_PATH = DRIVER_DIR + "geckodriver";

    public static String modifyIfWindows(String inPath) {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            return inPath + ".exe";
        } else {
            return inPath;
        }
    }

    public static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver",
                modifyIfWindows(CHROME_DRIVER_PATH));
        return new ChromeDriver();
    }

    public static WebDriver createGeckoDriver() {
        System.setProperty("webdriver.gecko.driver",
                modifyIfWindows(GECKO_DRIVER_PATH));
        return new FirefoxDriver();
    }

}
