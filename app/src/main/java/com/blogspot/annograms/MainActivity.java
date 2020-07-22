package com.blogspot.annograms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextInput;
    Button buttonShowResult;
    TextView textViewResult;

//    Write an application that reverses all the words of input text:
//
//    E.g. "abcd efgh" => "dcba hgfe"
//
//    All non-letter symbols should stay on the same places:
//
//    E.g. "a1bcd efg!h" => "d1cba hgf!e"


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
        objWithString.reverseWordInMyString(stringInput);
        textViewResult.setText(reverseWordInMyString(stringInput).toString());


    }
    public String reverseWordInMyString(String str) {
        String[] words = str.split(" ");
        String reversedString = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length()-1; j >= 0; j--) {
                if (!Character.isAlphabetic(word.charAt(j))) {
                    continue;
                } else {
                    reverseWord = reverseWord + word.charAt(j);
                }
            }
            reversedString = reversedString + reverseWord + " ";
        }
        return reversedString;
    }
}