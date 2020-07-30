package com.blogspot.annograms;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static com.blogspot.annograms.MakeAnnogramm.createAnagram;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonShowResult;
    private TextView textViewResult;
    private EditText editTextInput;

    public EditText getEditTextInput() {
        return editTextInput;
    }

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
    public void onClick(View v) {
        String anagramm = createAnagram(editTextInput.getText().toString());
        textViewResult.setText(anagramm);
    }

}