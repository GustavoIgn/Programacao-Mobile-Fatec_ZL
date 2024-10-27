package br.edu.fateczl.ex_11;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.ex_11.model.Ingressos;
import br.edu.fateczl.ex_11.model.IngressoVip;

public class MainActivity extends AppCompatActivity {

    private EditText etCodId, etFuncao;
    private RadioGroup radioGroup;
    private RadioButton radioTradicional, radioVip;
    private Button btnComprar;
    private TextView tvValor;
    private float valorIngresso = 52.00f;
    private float taxa = 12.00f;

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

        etCodId = findViewById(R.id.codId);
        etFuncao = findViewById(R.id.funcao);
        radioGroup = findViewById(R.id.radioGroup);
        radioTradicional = findViewById(R.id.radioTradicional);
        radioVip = findViewById(R.id.radioVip);
        btnComprar = findViewById(R.id.btnComprar);
        tvValor = findViewById(R.id.valor);

        // Exibe o valor do ingresso inicial
        tvValor.setText(String.format(getString(R.string.txt_valor), valorIngresso));
        
        // Esconde o campo de função inicialmente
        etFuncao.setVisibility(View.GONE);

        // Muda a visibilidade do campo de função com base na seleção do tipo de ingresso
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioVip) {
                etFuncao.setVisibility(View.VISIBLE);
            } else {
                etFuncao.setVisibility(View.GONE);
            }
        });

        // Configura o listener do botão de compra
        btnComprar.setOnClickListener(v -> calcularValor());
    }
    
    public void calcularValor() {
        String codigo = etCodId.getText().toString();
        boolean isVip = radioVip.isChecked();

        // Verifica se o código foi preenchido
        if (codigo.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
            return;
        }

        float valorFinal;
        String funcao = isVip ? etFuncao.getText().toString() : null;

        // Cria o ingresso com base no tipo selecionado
        if (isVip && !funcao.isEmpty()) {
            IngressoVip ingressoVIP = new IngressoVip(codigo, valorIngresso, funcao);
            valorFinal = ingressoVIP.valorFinal(taxa);
        } else if (isVip) {
            Toast.makeText(this, "Informe a função para o ingresso VIP", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Ingressos ingresso = new Ingressos(codigo, valorIngresso);
            valorFinal = ingresso.valorFinal(taxa);
        }

        // Prepara os dados para a próxima atividade
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("codigo", codigo);
        intent.putExtra("valorFinal", valorFinal);
        if (isVip) {
            intent.putExtra("funcao", funcao);
        }
        startActivity(intent);
    }
}
