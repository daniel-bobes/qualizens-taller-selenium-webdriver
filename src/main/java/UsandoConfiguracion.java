import org.openqa.selenium.WebDriver;

public class UsandoConfiguracion {
    public static void main(String[] args) throws Exception {
        WebDriver driver = common.Configuration.createChromeDriver();
        driver.get("https://www.google.es");
        Thread.sleep(5000);
        driver.quit();

        driver = common.Configuration.createGeckoDriver();
        driver.get("https://www.google.es");
        Thread.sleep(5000);
        driver.quit();
    }

}
