package com.blogspot.annograms;

import org.junit.Test;
import static org.junit.Assert.*;

public class MakeAnnogramUnitTest {
    private final MakeAnnogramm methodsFromMakeAnnogramm = new MakeAnnogramm();

    @Test
    public void reverseWordInMyStringIsCorrectCaseOne() {
        String str = "-9238%%217119!@# _+#*@!&@@*82839";
        assertEquals("-9238%%217119!@# _+#*@!&@@*82839 ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseTwo() {
        String str = "hello this is only adcdefg";
        assertEquals("olleh siht si ylno gfedcda ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseThree() {
        String str = "he3ll5o th@@is is on%^ly ad1cd3ef4g";
        assertEquals("ol3le5h si@@ht si yl%^no gf1ed3cd4a ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseFour() {
        String str = "5hello5 4this4 3is3 2only2 1adcdefg1";
        assertEquals("5olleh5 4siht4 3si3 2ylno2 1gfedcda1 ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseFive() {
        String str = "123*&@^#(@#";
        assertEquals("123*&@^#(@# ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseSix() {
        String str = "loremhello";
        assertEquals("ollehmerol ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseSeven() {
        String str = "olleh#merol";
        assertEquals("lorem#hello ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseEight() {
        String str = "1olleh#merol1";
        assertEquals("1lorem#hello1 ",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }


}