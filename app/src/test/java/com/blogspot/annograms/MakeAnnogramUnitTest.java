package com.blogspot.annograms;

import org.junit.Test;

import static com.blogspot.annograms.MakeAnnogramm.reverseWordInMyString;
import static org.junit.Assert.*;

public class MakeAnnogramUnitTest {

    @Test
    public void testNonSymbolicCharsNotReversed() {
        String str = "-9238%%217119!@# _+#*@!&@@*82839";
        assertEquals("-9238%%217119!@# _+#*@!&@@*82839 ",reverseWordInMyString(str));
    }

    @Test
    public void testAllCharsShouldReverseWholeLine() {
        String str = "hello this is only adcdefg";
        assertEquals("olleh siht si ylno gfedcda ", reverseWordInMyString(str));
    }

    @Test
    public void testOnlySymbolicCharsShouldReverse() {
        String str = "he3ll5o th@@is is on%^ly ad1cd3ef4g";
        assertEquals("ol3le5h si@@ht si yl%^no gf1ed3cd4a ", reverseWordInMyString(str));
    }

    @Test
    public void testReverseOnlySymbolicChars() {
        String str = "5hello5 4this4 3is3 2only2 1adcdefg1";
        assertEquals("5olleh5 4siht4 3si3 2ylno2 1gfedcda1 ", reverseWordInMyString(str));
    }

    @Test
    public void testNonSymbolicCharsNotReversedInOneWord() {
        String str = "123*&@^#(@#";
        assertEquals("123*&@^#(@# ", reverseWordInMyString(str));
    }

    @Test
    public void testAllCharsShouldReverseWholeLineInOneWord() {
        String str = "loremhello";
        assertEquals("ollehmerol ", reverseWordInMyString(str));
    }

    @Test
    public void testOnlySymbolicCharsShouldReverseInOneWord() {
        String str = "olleh#merol";
        assertEquals("lorem#hello ", reverseWordInMyString(str));
    }

    @Test
    public void testReverseOnlySymbolicCharsInOneWord() {
        String str = "1olleh#merol1";
        assertEquals("1lorem#hello1 ", reverseWordInMyString(str));
    }

    @Test
    public void testReverseEmptyString() {
        String str = "";
        assertEquals(" ", reverseWordInMyString(str));
    }

    @Test
    public void testReverseNullString() {
        String str = null;
        assertEquals("NULL", reverseWordInMyString(str));
    }
}