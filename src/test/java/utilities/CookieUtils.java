package utilities;

import org.openqa.selenium.Cookie;
import io.restassured.http.Cookies;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies) {
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies = cookies.asList();

        List<Cookie> seleniumCookies = new ArrayList<>();

        for (io.restassured.http.Cookie cookie : restAssuredCookies) {
            seleniumCookies.add(new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),
                    cookie.getPath(), cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(),
                    cookie.getSameSite()));
        }

        return seleniumCookies;
    }

}
