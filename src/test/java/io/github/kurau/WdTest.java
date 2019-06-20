package io.github.kurau;

import lombok.extern.log4j.Log4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;

@Log4j
@RunWith(Parameterized.class)
public class WdTest {

    @Parameter
    public String id;

    @Parameters
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

    @Test
    public void openTest() {
        long start = System.currentTimeMillis();
        wdRule.driver().get("https://realty.test.vertis.yandex.ru/sankt-peterburg/");
        log.info(" # " + (System.currentTimeMillis() - start));
    }
}
