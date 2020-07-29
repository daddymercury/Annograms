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
            reversedString = reversedString + reverse(partCharArr) + " ";
        }
        return reversedString;
    }

    static String reverse(char[] partCharArr) {
        int arrayStart = 0;
        int arrayEnd = partCharArr.length - 1;

        while (arrayStart < arrayEnd) {
            if (Character.isLetter(partCharArr[arrayStart]) && Character.isLetter(partCharArr[arrayEnd])) {
                char temp = partCharArr[arrayStart];
                partCharArr[arrayStart] = partCharArr[arrayEnd];
                partCharArr[arrayEnd] = temp;
                arrayStart++;
                arrayEnd--;
            }
            else if (Character.isLetter(partCharArr[arrayStart]) && !Character.isLetter(partCharArr[arrayEnd])) {
                arrayEnd--;
            }
            else if (!Character.isLetter(partCharArr[arrayStart]) && Character.isLetter(partCharArr[arrayEnd])) {
                arrayStart++;
            }
            else {
                arrayStart++;
                arrayEnd--;
            }
        }

        return String.valueOf(partCharArr);
    }


}
