package accion;

import common.ClaseBase2;
import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.*;

public class ManejandoVentanasTest extends ClaseBase2 {

    @Test
    public void test() {
        System.out.println(this.getDriver().getTitle()
                + " (" + this.getDriver().getCurrentUrl() + ")");
        System.out.println("Window handle: " + this.getDriver().getWindowHandle());
        String mainWindow = this.getDriver().getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        js.executeScript("window.open(arguments[0]);", Configuration.BLOG_URL);

        for (String handle : this.getDriver().getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                this.getDriver().switchTo().window(handle);
                System.out.println(this.getDriver().getTitle()
                        + " (" + this.getDriver().getCurrentUrl() + ")");
                System.out.println("Window handle: " + this.getDriver().getWindowHandle());
                this.getDriver().close();
            }
        }

        this.getDriver().switchTo().window(mainWindow);
        System.out.println(this.getDriver().getTitle()
                + " (" + this.getDriver().getCurrentUrl() + ")");
        System.out.println("Window handle: " + this.getDriver().getWindowHandle());

        assertEquals(1, this.getDriver().getWindowHandles().size(),
                "Verifico que solo queda 1 ventana activa");
    }
}
