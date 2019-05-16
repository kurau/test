package io.github.kurau;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void failTest() {
        assertThat("", true, is(true));
    }
}
