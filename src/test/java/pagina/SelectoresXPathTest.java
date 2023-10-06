package pagina;

import common.ClaseBase1;
import common.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectoresXPathTest extends ClaseBase1 {

    @Test
    public void test01() {
        WebElement element = driver.findElement(By.xpath("/html/body/div/form/p/input"));
        SeleniumUtils.printWebElementInfo("Ruta absoluta", element);
    }

    @Test
    public void test02() {
        WebElement element = driver.findElement(By.xpath("//input"));
        SeleniumUtils.printWebElementInfo("Ruta relativa", element);
    }

    @Test
    public void test03() {
        WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
        SeleniumUtils.printWebElementInfo("Ruta relativa y valor atributo", element);
    }

    @Test
    public void test04() {
        WebElement element = driver.findElement(By.xpath("//*[@type='text']"));
        SeleniumUtils.printWebElementInfo("Cualquier elemento con type='text'", element);
    }

    @Test
    public void test05() {
        WebElement element = driver.findElement(By.xpath("//*[text()='Lost your password?']"));
        SeleniumUtils.printWebElementInfo("Cualquier elemento con texto='Lost your password'", element);
    }

    @Test
    public void test06() {
        WebElement element = driver.findElement(By.xpath("//label[text()='Remember Me']"));
        SeleniumUtils.printWebElementInfo("Label con texto='Remember Me'", element);
    }

    @Test
    public void test07() {
        WebElement element = driver.findElement(By.xpath("//div/input"));
        SeleniumUtils.printWebElementInfo("Cualquier input hijo de un div ", element);
    }

    @Test
    public void test08() {
        WebElement element = driver.findElement(By.xpath("//form/p/following-sibling::p"));
        SeleniumUtils.printWebElementInfo("Todo p hermano del elemento actual", element);
    }

    @Test
    public void test09() {
        WebElement element = driver.findElement(By.xpath("//input[contains(@id, 'er_log')]"));
        SeleniumUtils.printWebElementInfo("Input cuyo atributo id contiene er_log ", element);
    }

    @Test
    public void test10() {
        WebElement element = driver.findElement(By.xpath("//input[starts-with(@id, 'user')]"));
        SeleniumUtils.printWebElementInfo("Input cuyo atributo id empieza por user", element);
    }

    @Test
    public void test11() {
        WebElement element = driver.findElement(By.xpath("//input[@class='input' and @name='log' and @type='text']"));
        SeleniumUtils.printWebElementInfo("Input con class=input, name=log y type=text", element);
    }

    @Test
    public void test12() {
        WebElement element = driver.findElement(By.xpath("//input[@type and not(@name='log')]"));
        SeleniumUtils.printWebElementInfo("Input que tenga el atributo @tyoe y @name != log", element);
    }

    @Test
    public void test13() {
        WebElement element = driver.findElement(By.xpath("//label/../.."));
        SeleniumUtils.printWebElementInfo("El padre del padre de todo label", element);
    }

    @Test
    public void test14() {
        WebElement element = driver.findElement(By.xpath("//form//input"));
        SeleniumUtils.printWebElementInfo("Todo input dentro de un form", element);
    }

    @Test
    public void test15() {
        WebElement element = driver.findElement(By.xpath("//input/ancestor::form"));
        SeleniumUtils.printWebElementInfo("Form ancestro de elemento input", element);
    }

    @Test
    public void test16() {
        WebElement element = driver.findElement(By.xpath("//p[@class='submit']/preceding-sibling::p"));
        SeleniumUtils.printWebElementInfo("Todo elemento p que sea hermano precedente al p con class='submit'", element);
    }

    @Test
    public void test17() {
        WebElement element = driver.findElement(By.xpath("//input[1]"));
        SeleniumUtils.printWebElementInfo("Primer input", element);
    }
}
