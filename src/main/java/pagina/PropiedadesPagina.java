package pagina;

import common.Configuration;
import org.openqa.selenium.WebDriver;

public class PropiedadesPagina {
    public static void main(String[] args) throws Exception {
        WebDriver driver = Configuration.createChromeDriver();

        driver.get(Configuration.ADMIN_URL);
        Thread.sleep(3000);

        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("TITLE: " + driver.getTitle());
        System.out.println("PAGE SOURCE: " + driver.getPageSource());

        System.out.println("Posición del título de la página en el HTML: "
                + driver.getPageSource().indexOf(driver.getTitle()));

        driver.quit();

    }
}
