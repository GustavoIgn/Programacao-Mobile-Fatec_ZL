package br.edu.fateczl.ex_4;

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

    private EditText editTextConsumo;
    private EditText editTextLitros;
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
        editTextConsumo = findViewById(R.id.editTextConsumo);
        editTextLitros = findViewById(R.id.editTextLitros);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularAutonomia();
            }
        });
    }

    private void calcularAutonomia() {
        String consumo = editTextConsumo.getText().toString();
        String litros = editTextLitros.getText().toString();

        if(consumo.isEmpty() || litros.isEmpty()) {
            Toast.makeText(this,getString(R.string.msg_vazio), Toast.LENGTH_SHORT).show();
            textViewResultado.setText(getString(R.string.msg_vazio));
        } else {
            try {

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Falha ao converter os valores", Toast.LENGTH_SHORT).show();
            }
                double consumoMedio = Double.parseDouble(consumo);
                double quantLitrosRestante = Double.parseDouble(litros);

                double autonomia = consumoMedio * quantLitrosRestante * 1000;

                textViewResultado.setText(String.format(getString(R.string.msg_autonomia), (int) autonomia));
        }

    }
}