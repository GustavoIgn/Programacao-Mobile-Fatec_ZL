package br.edu.fateczl.ex_6;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber;
    TextView outputCentena, outputDezena, outputUnidade, msgTela;
    Button decomporBtn;

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

        inputNumber = findViewById(R.id.inputNumber);
        outputCentena= findViewById(R.id.outputCentena);
        outputDezena= findViewById(R.id.outputDezena);
        outputUnidade= findViewById(R.id.outputUnidade);
        msgTela = findViewById(R.id.msgTela);
        decomporBtn = findViewById(R.id.decomporBtn);

        decomporBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String numberText = inputNumber.getText().toString();
                if (numberText.isEmpty()) {
                    msgTela.setText(getString(R.string.erro_vazio));
                    return;
                }

                int number = Integer.parseInt(numberText);

                if (number < 100 || number > 999) {
                    msgTela.setText(getString(R.string.erro_range));
                    return;
                }

                int centena = number / 100;
                int dezena = (number % 100) / 10;
                int unidade = number % 10;

                outputCentena.setText(getString(R.string.centena) + centena);
                outputDezena.setText(getString(R.string.dezena) + dezena);
                outputUnidade.setText(getString(R.string.unidade) + unidade);
            }
        });
    }
}