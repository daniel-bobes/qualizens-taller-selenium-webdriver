package pagina;

import common.ClaseBase1;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectorCSSTest extends ClaseBase1 {

    @Test
    public void testUsingInputTag() {
        WebElement element = driver.findElement(By.cssSelector("input"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingInputTagWithTypeAttribute() {
        WebElement element = driver.findElement(By.cssSelector("input[type]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingInputTagWithTypeAttributeEqualsToPassword() {
        WebElement element = driver.findElement(By.cssSelector("input[type='password']"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    // Símbolos especiales
    @Test
    public void testUsingIdSymbol() {
        WebElement element = driver.findElement(By.cssSelector("#nav"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingClassSymbol() {
        WebElement element = driver.findElement(By.cssSelector(".forgetmenot"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingAllElementsSymbolWithAttributeValueEqualsToNav() {
        WebElement element = driver.findElement(By.cssSelector("*[id=nav]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingPartialMatch1() {
        WebElement element = driver.findElement(By.cssSelector("input[id|=wp]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingPartialMatch2() {
        WebElement element = driver.findElement(By.cssSelector("input[name*=submit]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingPartialMatch3() {
        WebElement element = driver.findElement(By.cssSelector("input[class~=input]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingPartialMatch5() {
        WebElement element = driver.findElement(By.cssSelector("input[type^=check]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingPartialMatch4() {
        WebElement element = driver.findElement(By.cssSelector("input[class$=large]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    // Relaciones
    @Test
    public void testUsingSpace() {
        WebElement element = driver.findElement(By.cssSelector("div p"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsing2GreaterThan() {
        WebElement element = driver.findElement(By.cssSelector("div > p"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingPlus() {
        WebElement element = driver.findElement(By.cssSelector("script + p"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingIdAttribute() {
        WebElement element = driver.findElement(By.cssSelector("[id]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingClassAttribute() {
        WebElement element = driver.findElement(By.cssSelector("[class]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingNameAttribute() {
        WebElement element = driver.findElement(By.cssSelector("[name]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingAnd() {
        WebElement element = driver.findElement(By.cssSelector("input.password-input"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingOr() {
        WebElement element = driver.findElement(By.cssSelector("input, *[name=log]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingNot() {
        WebElement element = driver.findElement(By.cssSelector("input[type=hidden]:not([name=redirect_to])"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingMultipleAttribute() {
        WebElement element = driver.findElement(By.cssSelector("input[id][name][class][type][autocapitalize]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }

    @Test
    public void testUsingMultipleAttributeWithValues() {
        WebElement element = driver.findElement(By.cssSelector("input[type=hidden][name=redirect_to]"));
        SeleniumUtils.printWebElementInfo("Casilla de texto", element);
    }
}
