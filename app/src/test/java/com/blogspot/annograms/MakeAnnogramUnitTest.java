package com.blogspot.annograms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MakeAnnogramUnitTest {
    private final MakeAnnogramm methodsFromMakeAnnogramm = new MakeAnnogramm();

    @Test
    public void reversingIsCorrectCaseOne() {
        char[] partCharArr = {'a','b','c','d'};
        assertEquals("dcba",methodsFromMakeAnnogramm.reverse(partCharArr));
    }

    @Test
    public void reversingIsCorrectCaseTwo() {
        char[] partCharArr = {'e','f','g','h'};
        assertEquals("hgfe",methodsFromMakeAnnogramm.reverse(partCharArr));
    }

    @Test
    public void reversingIsCorrectCaseThree() {
        char[] partCharArr = {'a','1','b','c','d'};
        assertEquals("d1cba",methodsFromMakeAnnogramm.reverse(partCharArr));
    }

    @Test
    public void reversingIsCorrectCaseFour() {
        char[] partCharArr = {'e','f','g','!','h'};
        assertEquals("hgf!e",methodsFromMakeAnnogramm.reverse(partCharArr));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseOne() {
        String str = "abcd efgh";
        assertEquals("dcba hgfe",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseTwo() {
        String str = "a1bcd efg!h";
        assertEquals("d1cba hgf!e",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseThree() {
        String str = "o*********ne t1wo thr8--ee fo42ur fiv%#$#e";
        assertEquals("e*********no o1wt eer8--ht ru42of evi%#$#f",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

    @Test
    public void reverseWordInMyStringIsCorrectCaseFour() {
        String str = "s1`om,/et.6=hi88ng i4nte5re6sti9ng s1`om,/et.6=hi88ng i4nte5re6sti9ng o*********ne t1wo thr8--ee fo42ur fiv%#$#e";
        assertEquals("g1`ni,/ht.6=em88os g4nit5se6ret9ni g1`ni,/ht.6=em88os g4nit5se6ret9ni e*********no o1wt eer8--ht ru42of evi%#$#f",methodsFromMakeAnnogramm.reverseWordInMyString(str));
    }

}