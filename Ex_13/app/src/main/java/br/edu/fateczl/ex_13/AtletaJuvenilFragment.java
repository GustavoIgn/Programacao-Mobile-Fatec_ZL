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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import androidx.fragment.app.Fragment;

import br.edu.fateczl.ex_13.controller.OperacaoJuvenil;
import br.edu.fateczl.ex_13.model.AtletaJuvenil;

public class AtletaJuvenilFragment extends Fragment {
    private EditText etNome;
    private EditText etDataNascimento;
    private EditText etBairro;
    private EditText etAnosPraticaJuv;
    private Button btnCadastrar;
    private TextView tvResultado;
    private View view;

    private OperacaoJuvenil operacaoJuvenil;

    public AtletaJuvenilFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_atleta_juvenil, container, false);

        etNome = view.findViewById(R.id.etNome);
        etDataNascimento = view.findViewById(R.id.etDataNascimento);
        etBairro = view.findViewById(R.id.etBairro);
        etAnosPraticaJuv = view.findViewById(R.id.etAnosPraticaJuv);
        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        tvResultado = view.findViewById(R.id.tvResultado);
        operacaoJuvenil = OperacaoJuvenil.getInstance();

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
        int anosPratica = Integer.parseInt(etAnosPraticaJuv.getText().toString());

        AtletaJuvenil atleta = new AtletaJuvenil(nome, dataNascimento, bairro, anosPratica);
        operacaoJuvenil.cadastrar(atleta);
        Toast.makeText(getActivity(), "Atleta Juvenil cadastrado com sucesso: " + atleta.toString(), Toast.LENGTH_LONG).show();

        tvResultado.setText("Atleta Junior cadastrado com sucesso: " + atleta.toString());
    }
}