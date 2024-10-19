package br.edu.fateczl.ex_7;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupDados;
    private Spinner spinnerDados;
    private TextView tvResultado;
    private Button buttonRolar;

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

        radioGroupDados = findViewById(R.id.radioGroupDice);
        spinnerDados = findViewById(R.id.spinnerDiceCount);
        tvResultado = findViewById(R.id.textViewResult);
        buttonRolar = findViewById(R.id.buttonRoll);


        preencheSpinner();

        buttonRolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rolarDado();
            }

        });
    }

    private void preencheSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quant_dados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDados.setAdapter(adapter);
    }

    private void rolarDado() {
        if (radioGroupDados.getCheckedRadioButtonId() == -1) {
            tvResultado.setText("Selecione um dado.");
            return;
        }
        int selectedDice = getSelectedDice();
        int diceCount = Integer.parseInt(spinnerDados.getSelectedItem().toString());
        Random random = new Random();
        StringBuilder result = new StringBuilder("Resultados: ");

        for (int i = 0; i < diceCount; i++) {
            int roll = random.nextInt(selectedDice) + 1;
            result.append(roll).append(" ");
        }

        tvResultado.setText(result.toString());
    }

    private int getSelectedDice() {
        int selectedId = radioGroupDados.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        switch (selectedRadioButton.getText().toString()) {
            case "D4":
                return 4;
            case "D6":
                return 6;
            case "D8":
                return 8;
            case "D10":
                return 10;
            case "D12":
                return 12;
            case "D20":
                return 20;
            case "D100":
                return 100;
            default:
                return 6;
        }
    }
}
