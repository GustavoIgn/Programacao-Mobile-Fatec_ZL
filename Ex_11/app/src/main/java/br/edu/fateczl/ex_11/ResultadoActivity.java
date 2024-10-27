package br.edu.fateczl.ex_11;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    private TextView lblResultadoTitulo, lblResultadoTexto;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        // Inicializa os componentes do layout
        lblResultadoTitulo = findViewById(R.id.resultado_titulo);
        lblResultadoTexto = findViewById(R.id.resultado_texto);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Recebe os dados da Intent
        Intent intent = getIntent();
        float valorFinal = intent.getFloatExtra("valorFinal", 0);
        String codigoIngresso = intent.getStringExtra("codigo");
        String funcao = intent.getStringExtra("funcao");

        // Monta a string com os dados da compra
        String dados;
        if (funcao != null && !funcao.isBlank()) {
            dados = "INGRESSO VIP\nValor Final: " + valorFinal + "\nCódigo Ingresso: " + codigoIngresso +
                    "\nFunção: " + funcao;
        } else {
            dados = "INGRESSO COMUM\nValor Final: " + valorFinal + "\nCódigo Ingresso: " + codigoIngresso;
        }

        // Define o texto no TextView correspondente
        lblResultadoTexto.setText(dados);

        // Configura o listener do botão de voltar
        btnVoltar.setOnClickListener(op -> finish());
    }

}
