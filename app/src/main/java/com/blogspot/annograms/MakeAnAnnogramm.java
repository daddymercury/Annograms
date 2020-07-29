package com.blogspot.annograms;

import android.util.Log;

public class MakeAnAnnogramm {
    public static String createAnagram(String StringToReverse) {
        return reverseWordInMyString(StringToReverse);
    }

    public static String reverseWordInMyString(String str) {
        String[] words = str.split(" ");
        String reversedString = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            char[] partCharArr;
            partCharArr = new char[word.length()];
            for (int j = 0; j < word.length(); j++) {
                partCharArr[j] = word.charAt(j);
            }
            Log.d("partCharArr", reversedString);
            reversedString = reversedString + reverse(partCharArr) + " ";
        }
        Log.d("partCharArr = ", reversedString);
        return reversedString;
    }

    static String reverse(char[] partCharArr) {
        char temp;
        int j = partCharArr.length;
        int k = 0;
        for (int i = 0; i < partCharArr.length / 2; i++) {
            if (!Character.isLetter(partCharArr[k])) {
                k++;
                j++;
                i--;
            } else if (!Character.isLetter(partCharArr[j - 1 - k])) {
                j--;
            } else {
                temp = partCharArr[k];
                partCharArr[k] = partCharArr[j - 1 - i];
                partCharArr[j - 1 - i] = temp;
                k++;
                j--;
            }
        }
        return new String(partCharArr);
    }


}
