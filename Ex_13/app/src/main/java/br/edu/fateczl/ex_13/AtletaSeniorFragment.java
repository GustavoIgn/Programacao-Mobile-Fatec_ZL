package br.edu.fateczl.ex_13;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

import br.edu.fateczl.ex_13.controller.OperacaoSenior;
import br.edu.fateczl.ex_13.model.AtletaSenior;


public class AtletaSeniorFragment extends Fragment {
    private EditText etNome;
    private EditText etDataNascimento;
    private EditText etBairro;
    private CheckBox cbProblemasCardiacosSen;
    private Button btnCadastrar;
    private TextView tvResultado;

    private View view;
    private OperacaoSenior operacaoSenior;

    public AtletaSeniorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_senior, container, false);

        etNome = view.findViewById(R.id.etNome);
        etDataNascimento = view.findViewById(R.id.etDataNascimento);
        etBairro = view.findViewById(R.id.etBairro);
        cbProblemasCardiacosSen = view.findViewById(R.id.cbProblemasCardiacosSen);
        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        tvResultado = view.findViewById(R.id.tvResultado);

        operacaoSenior = OperacaoSenior.getInstance();

        etDataNascimento.setOnClickListener(v -> showDatePickerDialog());

        btnCadastrar.setOnClickListener(op -> cadastro());

        return view;
    }
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, year1, monthOfYear, dayOfMonth) -> {
                    String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                    etDataNascimento.setText(selectedDate);
                }, year, month, day);
        datePickerDialog.show();
    }

    private void cadastro() {
        String nome = etNome.getText().toString();
        String dataNascimento = etDataNascimento.getText().toString();
        String bairro = etBairro.getText().toString();
        boolean problemasCardiacos = cbProblemasCardiacosSen.isChecked();


        AtletaSenior atleta = new AtletaSenior(nome, dataNascimento, bairro, problemasCardiacos);
        operacaoSenior.cadastrar(atleta);

        Toast.makeText(getActivity(), "Atleta Senior cadastrado com sucesso: " + atleta.toString(), Toast.LENGTH_LONG).show();

        tvResultado.setText("Atleta Senior cadastrado com sucesso: " + atleta.toString());
    }
}