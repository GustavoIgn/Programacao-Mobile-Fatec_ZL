package br.edu.fateczl.ex_5;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
 */

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private EditText etDia, etMes, etAno;
    private Button btnCalcular;
    private TextView tvResultado;

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
        
        etDia = findViewById(R.id.editTextDia);
        etMes = findViewById(R.id.editTextMes);
        etAno = findViewById(R.id.editTextAno);
        btnCalcular = findViewById(R.id.buttonCalcular);
        tvResultado = findViewById(R.id.textViewResultado);
        
        btnCalcular.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               calcularIdade();
           } 
        });
    }
    
    private void calcularIdade() {
        int dia = Integer.parseInt(etDia.getText().toString());
        int mes = Integer.parseInt(etMes.getText().toString());
        int ano = Integer.parseInt(etAno.getText().toString());
        
        
        LocalDate dataAtual = LocalDate.now();
        
        if (dia < 0 || dia > 31) {
            tvResultado.setText("Data Inválida");
        }
        
        if (mes < 1 || mes > 12) {
            tvResultado.setText("Data Inválida");
        }
        
        if (ano > dataAtual.getYear()) {
            tvResultado.setText("Data Inválida");
        }
        
        int [] diasMes = new int[13];
        diasMes[1] = 31;
        diasMes[2] = isBissexto(ano) ? 29 : 28;
        diasMes[3] = 31;
        diasMes[4] = 30;
        diasMes[5] = 31;
        diasMes[6] = 30;
        diasMes[7] = 31;
        diasMes[8]= 31;
        diasMes[9] = 30;
        diasMes[10] = 31;
        diasMes[11] = 30;
        diasMes[12] = 31;
        
        if (dia > diasMes[mes]) {
            tvResultado.setText("Data Inválida");
        }
        
        diasMes[2] = isBissexto(dataAtual.getYear()) ? 29 : 28;
        int idA = dataAtual.getYear() - ano;
        int idM = dataAtual.getMonthValue() - mes;
        int idD = dataAtual.getDayOfMonth() - dia;
        
        if (idM < 0 || (idM == 0 && idD < 0)) {
            idA -= 1;
            idM += 12;
        }
        if (idM < 0) {
            idM += 12;
            idA -= 1;
        }
        if (idD < 0) {
            idD = idD + diasMes[(mes - 1) % 12];
            idM = idM - 1;
        }

        if (idM < 0) {
            idM = idM + 12;
            idA = idA - 1;
        }

        String resultado = getString(R.string.resultado, idA, idM, idD);
        tvResultado.setText(resultado);
    }

    public boolean isBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}