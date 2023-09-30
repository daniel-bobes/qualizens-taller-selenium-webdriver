import common.Configuration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class MetodosNavegador {
    public static void main(String[] args) throws Exception {
        WebDriver driver = Configuration.createChromeDriver();

        driver.get("https://www.google.es");
        driver.navigate().to("http://20.169.202.27/wp-admin/");

        Thread.sleep(2000);

        driver.manage().window().setSize(new Dimension(1024, 768));
        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.es");
        Thread.sleep(2000);

        String newWindow = driver.getWindowHandle();
        System.out.println("newWindow = " + newWindow);

        System.out.println("# de ventanas abiertas: " + driver.getWindowHandles().size());
        driver.switchTo().window(newWindow).close();
        System.out.println("# de ventanas abiertas: " + driver.getWindowHandles().size());

        driver.quit();

    }

}
