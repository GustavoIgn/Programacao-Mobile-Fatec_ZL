package br.edu.fateczl.ex_1;

/*
@author:<Gustavo da Silva Ignácio 1110482313006>
 */

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputA, inputB, inputC;
    private TextView resultDelta, resultX1, resultX2, errorMessage;
    private Button calculateButton;

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

        // Inicializa os componentes do layout
        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        inputC = findViewById(R.id.inputC);
        resultDelta = findViewById(R.id.resultDelta);
        resultX1 = findViewById(R.id.resultX1);
        resultX2 = findViewById(R.id.resultX2);
        errorMessage = findViewById(R.id.errorMessage);
        calculateButton = findViewById(R.id.calculateButton);

        // Configura o botão para realizar o cálculo
        calculateButton.setOnClickListener(v -> calculateEquation());
    }

    private void calculateEquation() {
        try {
            // Lê os valores de a, b e c a partir dos EditTexts
            double a = Double.parseDouble(inputA.getText().toString());
            double b = Double.parseDouble(inputB.getText().toString());
            double c = Double.parseDouble(inputC.getText().toString());

            // Verifica se é uma equação de 2º grau
            if (a == 0) {
                errorMessage.setText("Não é uma equação de 2º grau.");
                resultDelta.setText("");
                resultX1.setText("");
                resultX2.setText("");
            } else {
                // Calcula o valor de delta
                double delta = b * b - 4 * a * c;
                resultDelta.setText("Delta: " + delta);

                if (delta < 0) {
                    // Se delta for negativo, não tem raízes reais
                    errorMessage.setText("Não há raízes reais.");
                    resultX1.setText("");
                    resultX2.setText("");
                } else {
                    // Calcula as raízes X1 e X2
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    resultX1.setText("X1: " + x1);
                    resultX2.setText("X2: " + x2);
                    errorMessage.setText("");
                }
            }
        } catch (NumberFormatException e) {
            // Exibe erro se os valores de entrada forem inválidos
            errorMessage.setText("Por favor, insira valores válidos.");
        }
    }
}