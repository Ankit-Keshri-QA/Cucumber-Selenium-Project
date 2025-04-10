package domainObjects;

import org.openqa.selenium.WebDriver;
import utilities.CookieUtils;
import org.openqa.selenium.Cookie;

import java.util.List;

public class Cookies {

    private io.restassured.http.Cookies cookies;

    public io.restassured.http.Cookies getCookie() {
        return cookies;
    }

    public void setCookie(io.restassured.http.Cookies cookie) {
        this.cookies = cookie;
    }

    public void injectCookiesToBrowser(WebDriver driver) {
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        int i = 0;
        for (Cookie cookie : seleniumCookies) {
            System.out.println("COUNTER " + i + ": " + cookie.toString());
            driver.manage().addCookie(cookie);
            i++;
        }
    }
}
