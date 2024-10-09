package br.edu.fateczl.Ex_3;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
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

    private EditText editTextGasolina;
    private EditText editTextEtanol;
    private Button buttonCalcular;
    private TextView textViewResultado;


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

        //Referencia aos elementos da tela
        editTextGasolina = findViewById(R.id.editTextGasolina);
        editTextEtanol = findViewById(R.id.editTextEtanol);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularMelhorCombustivel();
            }
        });
    }

    private void calcularMelhorCombustivel() {
        String gasolina = editTextGasolina.getText().toString();
        String etanol = editTextEtanol.getText().toString();

        if(gasolina.isEmpty() || etanol.isEmpty()) {
            Toast.makeText(this,getString(R.string.msg_vazio), Toast.LENGTH_SHORT).show();
            textViewResultado.setText(getString(R.string.msg_vazio));
        } else {
            try {
                double valorGasolina = Double.parseDouble(gasolina);
                double valorEtanol = Double.parseDouble(etanol);

                if(valorEtanol / valorGasolina <= 0.7) {
                    textViewResultado.setText(getString(R.string.msg_Etanol));
                } else {
                    textViewResultado.setText(getString(R.string.msg_Gasolina));
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Erro ao converter valores. Verifique a entrada.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}