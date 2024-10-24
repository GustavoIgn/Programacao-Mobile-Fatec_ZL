package br.edu.fateczl.ex_10;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.ex_10.model.ContaBancaria;
import br.edu.fateczl.ex_10.model.ContaEspecial;
import br.edu.fateczl.ex_10.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText valorInput;
    private Button sacarButton;
    private Button depositarButton;
    private TextView resultadoText;
    private ContaBancaria contaSelecionada;
    private Button mostrarDadosButton;

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
        radioGroup = findViewById(R.id.radioGroup);
        valorInput = findViewById(R.id.valorInput);
        sacarButton = findViewById(R.id.sacarButton);
        depositarButton = findViewById(R.id.depositarButton);
        resultadoText = findViewById(R.id.resultadoText);
        mostrarDadosButton = findViewById(R.id.mostrarDadosButton);

        // Exemplo de contas
        ContaPoupanca contaPoupanca = new ContaPoupanca("Cliente A", 123, 1000, 5);
        ContaEspecial contaEspecial = new ContaEspecial("Cliente A", 124, 500, 200);

        // Evento para sacar
        sacarButton.setOnClickListener(v -> {
            String valorString = valorInput.getText().toString();
            if (valorString.isEmpty()) {
                resultadoText.setText(R.string.valor_invalido);
                return;
            }

            float valor = Float.parseFloat(valorString);
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == R.id.radioPoupanca) {
                contaSelecionada = contaPoupanca;
            } else {
                contaSelecionada = contaEspecial;
            }

            if (contaSelecionada != null) {
                contaSelecionada.sacar(valor);
                if (valor > contaSelecionada.getSaldo() && !(contaSelecionada instanceof ContaEspecial)) {
                    resultadoText.setText(R.string.saldo_insuficiente);
                } else {
                    resultadoText.setText(getString(R.string.novo_saldo, contaSelecionada.getSaldo()));
                }
            }
        });


        // Evento para depositar
        depositarButton.setOnClickListener(v -> {
            String valorString = valorInput.getText().toString();
            if (valorString.isEmpty()) {
                resultadoText.setText(R.string.valor_invalido);
                return;
            }

            float valor = Float.parseFloat(valorString);
            contaSelecionada.depositar(valor);
            resultadoText.setText(getString(R.string.novo_saldo, contaSelecionada.getSaldo()));

        });

        mostrarDadosButton.setOnClickListener(v -> {
            if (contaSelecionada != null) {
                resultadoText.setText(contaSelecionada.toString());
            } else {
                resultadoText.setText(R.string.selecionar_conta);
            }
        });
    }}