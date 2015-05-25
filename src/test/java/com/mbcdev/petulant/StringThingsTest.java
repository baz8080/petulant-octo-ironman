package com.mbcdev.petulant;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Tests the string functions that are found in {@link StringThings}
 *
 * Created by barry on 25/05/15.
 */
@RunWith(JUnitParamsRunner.class)
public class StringThingsTest {

    private StringThings stringThings;

    @Before
    public void setup() {
        this.stringThings = new StringThings();
    }


    @Test
    @Parameters({
            ",",
            "\t \n,",
            "a,a",
            "ab,ba",
            "abb,bba",
            "abba,abba",
            "abba music,cisum abba"
    })
    public void stringsShouldBeReversed(String input, String expected) {
        assertThat("The string should be reversed", stringThings.reverse(input), allOf(notNullValue(), is(expected)));
    }

    @Test
    public void reverseShouldReturnNullForNullArgument() {
        assertThat("reverse should return null if we pass null to it", stringThings.reverse(null), nullValue());
    }

    @Test
    @Parameters({
            ",",
            "a,a",
            "abb,ab2",
            "abba,ab2a",
            "abbcccddddeeeeef,ab2c3d4e5f",
            "abba music,ab2a music"
    })
    public void stringsShouldBeCompressed(String input, String expected) {
        assertThat("The string should be compressed", stringThings.compress(input), allOf(notNullValue(), is(expected)));
    }

    @Test
    public void compressShouldReturnNullForNullArgument() {
        assertThat("compress should return null if we pass null to it", stringThings.compress(null), nullValue());
    }
}
