package io.github.kurau;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Cookie;

import java.util.Collection;
import java.util.GregorianCalendar;

import static java.util.Arrays.asList;

@Log4j
@RunWith(Parameterized.class)
public class WdTest {

    private static final String COOKIE_DOMAIN = ".yandex.ru";

    @Parameter
    public String id;

    @Parameters(name = "{index} - open")
    public static Collection<Object[]> getData() {
        return asList(new Object[][]{
                {"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},
                {"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},
                {"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},
                {"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},
                {"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"},{"1"}
        });
    }

    @Rule
    public WdRule wdRule = new WdRule();

    @Before
    public void setCookies() {
        wdRule.driver().get("https://realty.test.vertis.yandex.ru/management-new/");
        wdRule.setCookie("exp_flags", "off:__ALL__", COOKIE_DOMAIN);
        wdRule.setCookie("certified-modal", "off", COOKIE_DOMAIN);
        wdRule.setCookie("subscription_popup_shown", "1", COOKIE_DOMAIN);//отключение попапа подписок
    }

    @Test
    @DisplayName("open")
    public void openTest() {
        long start = System.currentTimeMillis();
        wdRule.driver().get("https://realty.test.vertis.yandex.ru/sankt-peterburg/");
        log.info(" # " + (System.currentTimeMillis() - start));
    }
}
