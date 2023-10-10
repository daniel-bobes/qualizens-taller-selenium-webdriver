package accion;

import common.ClaseBase2;
import common.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class ManejandoCookiesTest extends ClaseBase2 {

    @Test
    public void testCookie() {
        Set<Cookie> allCookies = this.getDriver().manage().getCookies();

        for (Cookie cookie : allCookies) {
            System.out.println("Información de Cookie:");
            System.out.println("Nombre: " + cookie.getName());
            System.out.println("Valor: " + cookie.getValue());
            System.out.println("Dominio: " + cookie.getDomain());
            System.out.println("Ruta (path): " + cookie.getPath());
            System.out.println("Segura?: " + cookie.isSecure());
            System.out.println("HttpOnly?: " + cookie.isHttpOnly());
            System.out.println("*".repeat(40));
        }

        this.getDriver().manage().deleteAllCookies();

        this.getDriver().navigate().refresh();

        for (Cookie cookie : allCookies) {
            this.getDriver().manage().addCookie(cookie);
        }

        getDriver().navigate().to(Configuration.ADMIN_URL);
    }
}
