package com.blogspot.annograms;

public class MakeAnnogramm {

    public static String reverseWordInMyString(String str) {
        boolean isNull = false;
        try {
            str.equalsIgnoreCase(null);
        } catch (NullPointerException npe) {
            isNull = true;
        }
        if (isNull) {
            return "NULL";
        } else {
            String[] words = str.split(" ");
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                result.append(reverse(word.toCharArray()) + " ");
            }
            return result.toString();
        }
    }

    private static String reverse(char[] partCharArr) {
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
