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

    @Test
    @Parameters({
            "a,a",
            "aba,b",
            "a b c a b,c",
            "aabbccd,d",
            "dccbbaa,d",
            "a ba,b"

    })
    public void stringsShouldBeCompressed(String input, Character expected) {
        assertThat("The string should be compressed", stringThings.findFirstNonRepeatingCharacter(input), allOf(notNullValue(), is(expected)));
    }

    @Test
    public void rotateByNShouldReturnNull() {
        assertThat(stringThings.rotateByN(null, 13), nullValue());
    }

    @Test
    @Parameters({
            ",13,",
            "az,-1,zy",
            "az,1,ba",
            "az,-26,az",
            "az,26,az",
            "az,-27,zy",
            "az,27,ba",
            "!@£$,13,!@£$",
            "Rotation By 13,13,Ebgngvba Ol 13",
            "abcdefghijklmnopqrstuvwxyz,13,nopqrstuvwxyzabcdefghijklm",
            "abcdefghijklmnopqrstuvwxyz,16,qrstuvwxyzabcdefghijklmnop"

    })
    public void stringsShouldBeRotatedByN(String input, int rotation, String expected) {
        String rotated = stringThings.rotateByN(input, rotation);

        assertThat("rotation should be correct", rotated, allOf(notNullValue(), is(expected)));
        assertThat(
                "negative rotation should give the original input",
                stringThings.rotateByN(rotated, -rotation),
                allOf(notNullValue(), is(input))
        );
    }

    @Test
    public void rotateByNMapShouldReturnNull() {
        assertThat(stringThings.rotateByNMap(null, 13), nullValue());
    }

    @Test
    @Parameters({
            ",13,",
            "az,-1,zy",
            "az,1,ba",
            "az,-26,az",
            "az,26,az",
            "az,-27,zy",
            "az,27,ba",
            "!@£$,13,!@£$",
            "Rotation By 13,13,Ebgngvba Ol 13",
            "abcdefghijklmnopqrstuvwxyz,13,nopqrstuvwxyzabcdefghijklm",
            "abcdefghijklmnopqrstuvwxyz,16,qrstuvwxyzabcdefghijklmnop"

    })
    public void stringsShouldBeRotatedByNMap(String input, int rotation, String expected) {
        String rotated = stringThings.rotateByNMap(input, rotation);

        assertThat("rotation should be correct", rotated, allOf(notNullValue(), is(expected)));
        assertThat(
                "negative rotation should give the original input",
                stringThings.rotateByN(rotated, -rotation),
                allOf(notNullValue(), is(input))
        );
    }
}
