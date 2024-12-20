package br.edu.fateczl.ex_15;

/*
@author<Gustavo da Silva Ignacio 111082313006>
 */

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.*;

import br.edu.fateczl.ex_15.controller.JogadorController;
import br.edu.fateczl.ex_15.controller.TimeController;
import br.edu.fateczl.ex_15.model.Jogador;
import br.edu.fateczl.ex_15.model.Time;
import br.edu.fateczl.ex_15.persistence.JogadorDao;
import br.edu.fateczl.ex_15.persistence.TimeDao;

public class JogadorFragment extends Fragment {

    private View view;
    private EditText etIDJogador,
    etNomeJogador,
    etDataNascJogador,
    etAlturaJogador,
    etPesoJogador;
    private Spinner spTimeJog;
    private Button btnInserirJogador,
    btnAlterarJogador,
    btnExcluirJogador,
    btnListarJogador,
    btnBuscarJogador;
    private TextView tvListarJogador;
    private JogadorController jCont;
    private TimeController tCont;
    private List < Time > times;

    public JogadorFragment() {
        super();
    }

     @ Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_jogador, container, false);
        etIDJogador = view.findViewById(R.id.etIDJogador);
        etNomeJogador = view.findViewById(R.id.etNomeJogador);
        etDataNascJogador = view.findViewById(R.id.etDataNascJogador);
        etAlturaJogador = view.findViewById(R.id.etAlturaJogador);
        etPesoJogador = view.findViewById(R.id.etPesoJogador);
        spTimeJog = view.findViewById(R.id.spTimeJog);
        btnAlterarJogador = view.findViewById(R.id.btnAlterarJogador);
        btnBuscarJogador = view.findViewById(R.id.btnBuscarJogador);
        btnExcluirJogador = view.findViewById(R.id.btnExcluirJogador);
        btnInserirJogador = view.findViewById(R.id.btnInserirJogador);
        btnListarJogador = view.findViewById(R.id.btnListarJogador);
        tvListarJogador = view.findViewById(R.id.tvListarJogador);
        tvListarJogador.setMovementMethod(new ScrollingMovementMethod());

        jCont = new JogadorController(new JogadorDao(view.getContext()));
        tCont = new TimeController(new TimeDao(view.getContext()));
        preencheSpinner();

        btnInserirJogador.setOnClickListener(op->acaoInserir());
        btnAlterarJogador.setOnClickListener(op->acaoModificar());
        btnExcluirJogador.setOnClickListener(op->acaoExcluir());
        btnBuscarJogador.setOnClickListener(op->acaoBuscar());
        btnListarJogador.setOnClickListener(op->acaoListar());

        return view;
    }

    private void acaoInserir() {
        int spPos = spTimeJog.getSelectedItemPosition();
        if (spPos > 0) {
            Jogador jogador = montajogador();
            try {
                jCont.insert(jogador);
                Toast.makeText(view.getContext(), "Jogador Inserido com Sucesso!",
                    Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione um Time",
                Toast.LENGTH_LONG).show();
        }

    }

    private void acaoModificar() {
        int spPos = spTimeJog.getSelectedItemPosition();
        if (spPos > 0) {
            Jogador jogador = montajogador();
            try {
                jCont.modificar(jogador);
                Toast.makeText(view.getContext(), "Jogador Atualizado com Sucesso!",
                    Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            limpaCampos();
        } else {
            Toast.makeText(view.getContext(), "Selecione um Time",
                Toast.LENGTH_LONG).show();
        }
    }

    private void acaoExcluir() {
        Jogador jogador = montajogador();
        try {
            jCont.delete(jogador);
            Toast.makeText(view.getContext(), "Jogador Excluído com Sucesso!",
                Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void acaoBuscar() {
        Jogador jogador = montajogador();
        try {
            times = tCont.listar();
            jogador = jCont.buscar(jogador);
            if (jogador.getNome() != null) {
                preencherCampos(jogador);
            } else {
                Toast.makeText(view.getContext(), "Jogador não encontrado", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoListar() {
        try {
            List < Jogador > jogadores = jCont.listar();
            StringBuffer buffer = new StringBuffer();
            for (Jogador j: jogadores) {
                buffer.append(j.toString() + "\n");
            }
            tvListarJogador.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Jogador montajogador() {
        try {
            Jogador j = new Jogador();
            j.setId(Integer.parseInt(etIDJogador.getText().toString()));
            j.setNome(etNomeJogador.getText().toString());

            String dataNasc = etDataNascJogador.getText().toString();
            if (!dataNasc.isEmpty()) {
                j.setDtNasc(dataNasc);
            } else {
                throw new IllegalArgumentException("Data de nascimento é obrigatória.");
            }

            j.setAltura(Float.parseFloat(etAlturaJogador.getText().toString()));
            j.setPeso(Float.parseFloat(etPesoJogador.getText().toString()));

            int spPos = spTimeJog.getSelectedItemPosition();
            if (spPos > 0) {
                j.setTime(times.get(spPos));
            } else {
                throw new IllegalArgumentException("Selecione um time.");
            }
            return j;
        } catch (NumberFormatException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void preencherCampos(Jogador j) {
        etIDJogador.setText(String.valueOf(j.getId()));
        etNomeJogador.setText(String.valueOf(j.getNome()));
        etDataNascJogador.setText(j.getDtNasc());
        etAlturaJogador.setText(String.valueOf(j.getAltura()));
        etPesoJogador.setText(String.valueOf(j.getPeso()));

        int cont = 1;
        for (Time t: times) {
            if (t.getCodigo() == j.getTime().getCodigo()) {
                spTimeJog.setSelection(cont);
            } else {
                cont++;
            }
        }
        if (cont > times.size()) {
            spTimeJog.setSelection(0);
        }
    }

    private void limpaCampos() {
        etIDJogador.setText("");
        etNomeJogador.setText("");
        etDataNascJogador.setText("");
        etAlturaJogador.setText("");
        etPesoJogador.setText("");
        spTimeJog.setSelection(0);
    }

    private void preencheSpinner() {

        Time t0 = new Time();
        t0.setCodigo(0);
        t0.setNome("Selecione um Time");
        t0.setCidade("");

        try {
            times = tCont.listar();
            if (times == null) {
                times = new ArrayList <  > ();
            }
            times.add(0, t0);

            ArrayAdapter < Time > ad = new ArrayAdapter <  > (view.getContext(),
                    android.R.layout.simple_spinner_item,
                    times);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spTimeJog.setAdapter(ad);
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
