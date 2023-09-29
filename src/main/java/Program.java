import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.quit();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.quit();
    }
}
