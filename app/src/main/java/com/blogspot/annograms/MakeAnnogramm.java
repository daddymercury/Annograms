package com.blogspot.annograms;

public class MakeAnnogramm {

    public static String reverseWordInMyString(String str) {
        String[] words = str.split(" ");
        StringBuilder stringBuilderResult = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            stringBuilderResult.append(reverse(word.toCharArray()) + " ");
        }
        return stringBuilderResult.toString();
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
