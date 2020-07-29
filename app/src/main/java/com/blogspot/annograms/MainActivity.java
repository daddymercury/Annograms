package com.blogspot.annograms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//    Write an application that reverses all the words of input text:
//
//    E.g. "abcd efgh" => "dcba hgfe"
//
//    All non-letter symbols should stay on the same places:
//
//    E.g. "a1bcd efg!h" => "d1cba hgf!e"

public class MainActivity extends AppCompatActivity {
   private EditText editTextInput;
    private Button buttonShowResult;
    private TextView textViewResult;
    private String reversedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput = findViewById(R.id.editTextInput);
        buttonShowResult = findViewById(R.id.buttonShowResult);
        textViewResult = findViewById(R.id.textViewResult);

    }

    public void convertString(View view) {

        String stringInput = editTextInput.getText().toString();
        MainActivity objWithString = new MainActivity();
        reverseWordInMyString(stringInput);
        textViewResult.setText(reverseWordInMyString(stringInput).toString());


    }
    public String reverseWordInMyString(String str) {
        String[] words = str.split(" ");
        String rreversedString = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            char[] partCharArr;
//            for (int j = word.length()-1; j >= 0; j--) {
//                if (!Character.isAlphabetic(word.charAt(j))) {
//                   continue;
//                   // reverseWord = reverseWord + word.charAt(j+1);
//                } else {
//                    reverseWord = reverseWord + word.charAt(j);
//                }
//            }
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


    String reverse(char[] partCharArr) {
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