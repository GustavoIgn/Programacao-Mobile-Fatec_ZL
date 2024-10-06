package br.edu.fateczl.ex_2;

/*
@author:<Gustavo da Silva Ignácio 1110482313006>
 */

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText baseMaiorInput, baseMenorInput, alturaInput;
    private TextView resultadoTextView;
    private Button calcularButton;

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

        // Vinculando os componentes do layout com o código Java
        baseMaiorInput = findViewById(R.id.baseMaior);
        baseMenorInput = findViewById(R.id.baseMenor);
        alturaInput = findViewById(R.id.altura);
        calcularButton = findViewById(R.id.calcularButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        // Definindo o comportamento do botão calcular
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularArea();
            }
        });
    }

    // Função para calcular a área do trapézio
    private void calcularArea() {
        // Pegando os valores inseridos nos EditTexts
        String baseMaiorStr = baseMaiorInput.getText().toString();
        String baseMenorStr = baseMenorInput.getText().toString();
        String alturaStr = alturaInput.getText().toString();

        // Verificando se todos os campos foram preenchidos
        if (baseMaiorStr.isEmpty() || baseMenorStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, getString(R.string.preencher_campos), Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertendo os valores para inteiros
        int baseMaior = Integer.parseInt(baseMaiorStr);
        int baseMenor = Integer.parseInt(baseMenorStr);
        int altura = Integer.parseInt(alturaStr);

        // Calculando a área do trapézio
        int area = ((baseMaior + baseMenor) * altura) / 2;

        // Exibindo o resultado no TextView
        resultadoTextView.setText("Resultado: " + area);
    }
}