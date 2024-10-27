package br.edu.fateczl.ex_12;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.resultado_texto);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        if (intent != null) {
            String cpf = intent.getStringExtra("cpf");
            String nome = intent.getStringExtra("nome");

            // Obter o estado de origem com base no 9º dígito do CPF
            String estadoOrigem = getEstadoOrigem(cpf);
            
            tvResultado.setText("CPF: " + cpf + "\nNome: " + nome + "\nEstado de Origem: " + estadoOrigem);
        }

        btnVoltar.setOnClickListener(v -> finish());
    }

    private String getEstadoOrigem(String cpf) {
        if (cpf != null && cpf.length() >= 9) {
            char nonoDigito = cpf.charAt(8); // 9º dígito (índice 8)
            switch (nonoDigito) {
                case '1':
                    return "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
                case '2':
                    return "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima";
                case '3':
                    return "Ceará, Maranhão e Piauí";
                case '4':
                    return "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas";
                case '5':
                    return "Bahia e Sergipe";
                case '6':
                    return "Minas Gerais";
                case '7':
                    return "Rio de Janeiro e Espírito Santo";
                case '8':
                    return "São Paulo";
                case '9':
                    return "Paraná e Santa Catarina";
                case '0':
                    return "Rio Grande do Sul";
                default:
                    return "Estado desconhecido";
            }
        } else {
            return "CPF inválido";
        }
    }
}
