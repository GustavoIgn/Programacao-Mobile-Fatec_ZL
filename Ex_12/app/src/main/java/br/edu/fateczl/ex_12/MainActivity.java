package br.edu.fateczl.ex_12;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import br.edu.fateczl.ex_12.model.Pessoa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etCPF, etNome;
    private Button btnLocalizar;

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

        etCPF = findViewById(R.id.cpf);
        etNome = findViewById(R.id.nome);
        btnLocalizar = findViewById(R.id.btnLocal);

        btnLocalizar.setOnClickListener(v -> {
            String cpf = etCPF.getText().toString();
            String nome = etNome.getText().toString();
 
            if (cpf.isEmpty() || nome.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }
  
            Pessoa pessoa = new Pessoa(cpf, nome);

            Bundle bundle = new Bundle();
            bundle.putString("cpf", pessoa.cpf);
            bundle.putString("nome", pessoa.nome);

            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtras(bundle);
            this.startActivity(intent);
        });
    }
}