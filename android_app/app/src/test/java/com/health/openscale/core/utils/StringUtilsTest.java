package com.health.openscale.core.utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void isNullOrWhitespace() {
        String stringTest = new String("");
        assertTrue(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String("\n");
        assertTrue(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String("\r");
        assertTrue(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String("\t");
        assertTrue(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String(" ");
        assertTrue(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String("\n\t\r    \t");
        assertTrue(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String("\n\t\r  d  \t");
        assertFalse(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String("r\n\t\r    \t");
        assertFalse(StringUtils.isNullOrWhitespace(stringTest));

        stringTest = new String("\n\t\r    \t1");
        assertFalse(StringUtils.isNullOrWhitespace(stringTest));
    }

    @Test
    public void splitByWhitespace() {
        String stringTest = new String("\n\t\r    \t1 2\t\t\n3");
        String[] stringsSplitted =StringUtils.splitByWhitespace(stringTest);

        String[] expected = new String[]{"1", "2", "3"};
        assertArrayEquals(expected,stringsSplitted);

        stringTest = new String("\n\t\r    \t1 2\t\t\n3 \t\n\r");
        stringsSplitted =StringUtils.splitByWhitespace(stringTest);

        expected = new String[]{"1", "2", "3"};
        assertArrayEquals(expected,stringsSplitted);

        stringTest = new String("1 2\t\t\n3 \t\n\r");
        stringsSplitted =StringUtils.splitByWhitespace(stringTest);

        expected = new String[]{"1", "2", "3"};
        assertArrayEquals(expected,stringsSplitted);
    }

    @Test
    public void generateStringWithRepeatingChar() {
        String testString = StringUtils.generateStringWithRepeatingChar(6);
        String expected = "      ";
        assertEquals(expected, testString);

        testString = StringUtils.generateStringWithRepeatingChar(4, 'c');
        expected = "cccc";
        assertEquals(expected, testString);
    }
}