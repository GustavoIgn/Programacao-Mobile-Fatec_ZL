package br.edu.fateczl.ex_8;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBits;
    private Spinner spinnerUnits;
    private TextView tvResultado;
    private Button buttonConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextBits = findViewById(R.id.editTextBits);
        spinnerUnits = findViewById(R.id.spinnerUnits);
        tvResultado = findViewById(R.id.textViewResultado);
        buttonConverter = findViewById(R.id.buttonConverter);

        preencheSpinner();

        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                converterBits();
            }

        });
    }
    private void preencheSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipoByte, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnits.setAdapter(adapter);
    }

    private void converterBits() {
        String input = editTextBits.getText().toString();
        if (input.isEmpty()) {
            tvResultado.setText("Por favor, insira um valor em bits.");
            return;
        }

        double bits = Double.parseDouble(input);
        String selectedUnit = spinnerUnits.getSelectedItem().toString();
        double result = 0;

        switch (selectedUnit) {
            case "Bytes":
                result = bits / 8;
                break;
            case "KB":
                result = bits / (8 * 1024);
                break;
            case "MB":
                result = bits / (8 * 1024 * 1024);
                break;
            case "GB":
                result = bits / (8 * 1024 * 1024 * 1024);
                break;
            case "TB":
                result = bits / (8 * 1024 * 1024 * 1024 * 1024);
                break;
        }

        tvResultado.setText(String.format("Resultado: %.2f %s", result, selectedUnit));
    }
}