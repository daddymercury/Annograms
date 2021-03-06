package com.blogspot.annograms;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.blogspot.annograms.MakeAnnogramm.reverseWordInMyString;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonShowResult;
    private TextView textViewResult;
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonShowResult = findViewById(R.id.buttonShowResult);
        textViewResult = findViewById(R.id.textViewResult);
        editTextInput = findViewById(R.id.editTextInput);
        buttonShowResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) throws IllegalArgumentException {
        try {
            String anagramm = reverseWordInMyString(editTextInput.getText().toString());
            textViewResult.setText(anagramm);
        } catch (IllegalArgumentException argument) {
            messageToastView(argument);
        }
    }

   void messageToastView(IllegalArgumentException argument) {
       Toast toast = Toast.makeText(getApplicationContext(),
               argument.getMessage(),
               Toast.LENGTH_SHORT);
       toast.setGravity(Gravity.CENTER, 0, 0);
       toast.show();
   }

}