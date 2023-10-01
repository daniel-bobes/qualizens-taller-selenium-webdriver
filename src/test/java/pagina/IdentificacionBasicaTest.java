package pagina;

import common.ClaseBase1;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IdentificacionBasicaTest extends ClaseBase1 {

    @Test
    public void testByName() {
        WebElement usernameTextField = driver.findElement(By.name("log"));
        // System.out.println(usernameTextField);
        SeleniumUtils.printWebElementInfo("Username text field", usernameTextField);

        WebElement passwordTextField = driver.findElement(By.name("pwd"));
        SeleniumUtils.printWebElementInfo("Password text field", passwordTextField);

        // Lanza la excepción NoSuchElementException ya que no encuentra ningún elemento con name = "Other"
        // WebElement otherTextField = driver.findElement(By.name("other"));
        // SeleniumUtils.printWebElementInfo("Password text field", otherTextField);
    }

}
