package io.github.kurau;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class App2Test {

    @Test
    public void failTest() {
        assertThat("", true, is(false));
    }
}
