package br.edu.fateczl.ex_10;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ContaPoupanca contaPoupanca;
    private ContaEspecial contaEspecial;
    private RadioGroup radioGroup;
    private EditText valorSacar, valorDepositar, taxaRendimento;
    private TextView saldoView;

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
        valorSacar = findViewById(R.id.valorSacar);
        valorDepositar = findViewById(R.id.valorDepositar);
        taxaRendimento = findViewById(R.id.taxaRendimento);
        saldoView = findViewById(R.id.saldoView);

        contaPoupanca = new ContaPoupanca("Cliente Poupança", 1234, 1000.0f, 15);
        contaEspecial = new ContaEspecial("Cliente Especial", 5678, 500.0f, 1000.0f);

        findViewById(R.id.btnSacar).setOnClickListener(v -> sacar());
        findViewById(R.id.btnDepositar).setOnClickListener(v -> depositar());
        findViewById(R.id.btnMostrarSaldo).setOnClickListener(v -> mostrarSaldo());
    }

    private void sacar() {
        float valor = Float.parseFloat(valorSacar.getText().toString());
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.radioPoupanca) {
            if (!contaPoupanca.sacar(valor)) {
                Toast.makeText(this, "Saldo insuficiente!", Toast.LENGTH_SHORT).show();
            }
        } else if (selectedId == R.id.radioEspecial) {
            if (!contaEspecial.sacar(valor)) {
                Toast.makeText(this, "Saldo + Limite insuficiente!", Toast.LENGTH_SHORT).show();
            }
        }
        mostrarSaldo();
    }

    private void depositar() {
        float valor = Float.parseFloat(valorDepositar.getText().toString());
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.radioPoupanca) {
            contaPoupanca.depositar(valor);
        } else if (selectedId == R.id.radioEspecial) {
            contaEspecial.depositar(valor);
        }
        mostrarSaldo();
    }

    private void mostrarSaldo() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.radioPoupanca) {
            // Mostrar saldo e calcular rendimento
            float taxa = Float.parseFloat(taxaRendimento.getText().toString());
            contaPoupanca.calcularNovoSaldo(taxa);
            saldoView.setText(contaPoupanca.toString());
        } else if (selectedId == R.id.radioEspecial) {
            saldoView.setText(contaEspecial.toString());
        }
    }
}