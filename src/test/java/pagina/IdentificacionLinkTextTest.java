package pagina;

import common.ClaseBase1;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IdentificacionLinkTextTest extends ClaseBase1 {
    @Test
    public void testLostYourPasswordLinkByLinkText() {
        WebElement element = driver.findElement(By.linkText("Lost your password?"));
        SeleniumUtils.printWebElementInfo("Lost your password link", element);

    }

    @Test
    public void testBlogLinkByPartialLinkText() {
        WebElement element = driver.findElement(By.partialLinkText("Go to"));
        SeleniumUtils.printWebElementInfo("Go to User's Blog link", element);

    }
}
