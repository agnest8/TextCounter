package com.example.textcounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private Spinner spinnerType;
    private Button btnCalculate;
    private TextView txtResult;
    private TextCounter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.editTextInput);
        spinnerType = findViewById(R.id.spinnerType);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        counter = new TextCounter();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = txtInput.getText().toString().trim();

                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.toast_empty), Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedPosition = spinnerType.getSelectedItemPosition();
                int result = 0;

                if (selectedPosition == 0) {
                    result = counter.countWords(inputText);
                } else if (selectedPosition == 1) {
                    result = counter.countCharacters(inputText);
                }

                String resultFormat = getString(R.string.result_format);
                String finalResult = String.format(resultFormat, result);
                txtResult.setText(finalResult);
            }
        });
    }
}