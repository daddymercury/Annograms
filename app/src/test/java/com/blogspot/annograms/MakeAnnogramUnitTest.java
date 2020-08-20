package com.blogspot.annograms;

import org.junit.Test;

import static com.blogspot.annograms.MakeAnnogramm.reverseWordInMyString;
import static org.junit.Assert.*;


public class MakeAnnogramUnitTest {

    @Test
    public void testNonSymbolicCharsNotReversed() {

        String stringToReverse = "-9238%%217119!@# _+#*@!&@@*82839";
        String expectedResult = "-9238%%217119!@# _+#*@!&@@*82839 ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }

    @Test
    public void testAllCharsShouldReverseWholeLine() {

        String stringToReverse = "hello this is only adcdefg";
        String expectedResult = "olleh siht si ylno gfedcda ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }

    @Test
    public void testOnlySymbolicCharsShouldReverse() {

        String stringToReverse = "he3ll5o th@@is is on%^ly ad1cd3ef4g";
        String expectedResult = "ol3le5h si@@ht si yl%^no gf1ed3cd4a ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }

    @Test
    public void testReverseOnlySymbolicChars() {

        String stringToReverse = "5hello5 4this4 3is3 2only2 1adcdefg1";
        String expectedResult = "5olleh5 4siht4 3si3 2ylno2 1gfedcda1 ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }

    @Test
    public void testNonSymbolicCharsNotReversedInOneWord() {

        String stringToReverse = "123*&@^#(@#";
        String expectedResult = "123*&@^#(@# ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }

    @Test
    public void testAllCharsShouldReverseWholeLineInOneWord() {

        String stringToReverse = "loremhello";
        String expectedResult = "ollehmerol ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }

    @Test
    public void testOnlySymbolicCharsShouldReverseInOneWord() {

        String stringToReverse = "olleh#merol";
        String expectedResult = "lorem#hello ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }

    @Test
    public void testReverseOnlySymbolicCharsInOneWord() {

        String stringToReverse = "1olleh#merol1";
        String expectedResult = "1lorem#hello1 ";

        assertEquals(expectedResult, reverseWordInMyString(stringToReverse));
    }
}