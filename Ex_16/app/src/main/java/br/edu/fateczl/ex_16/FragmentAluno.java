package br.edu.fateczl.ex_16;

/*
@author: <Gustavo da Silva Ignacio 1110482313006>
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.ex_16.controller.*;
import br.edu.fateczl.ex_16.model.*;
//import br.edu.fateczl.ex_16.persistencia.*;

import android.database.SQLException;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class FragmentAluno extends Fragment {

    private EditText editTextRA;
    private EditText editTextNome;
    private EditText editTextEmail;
    private Button buttonSalvar,
    buttonApagar,
    buttonEditar,
    buttonListar,
    buttonBuscar;
    private TextView tvResultado;
    private View view;

    public FragmentAluno() {
        super();
    }

     @ Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_aluno, container, false);

        // Inicialização dos campos e botões
        editTextRA = view.findViewById(R.id.editTextRA);
        editTextNome = view.findViewById(R.id.editTextNome);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        buttonSalvar = view.findViewById(R.id.buttonSalvar);
        buttonListar = view.findViewById(R.id.buttonListar);
        buttonApagar = view.findViewById(R.id.buttonApagar);
        buttonEditar = view.findViewById(R.id.buttonEditar);
        buttonBuscar = view.findViewById(R.id.buttonBuscar);
        tvResultado = view.findViewById(R.id.tvListaAnimais);
        tvResultado.setMovementMethod(new ScrollingMovementMethod());
		
		tvResultado.setText("Exemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\n");

        /*// Configuração dos botões
        buttonSalvar.setOnClickListener(v->salvar());
        buttonListar.setOnClickListener(v->listar());
        buttonApagar.setOnClickListener(v->apagar());
        buttonEditar.setOnClickListener(v->editar());
        buttonBuscar.setOnClickListener(v->buscar());*/

        return view;
    }
	/*
    // Método para salvar
    private void salvar() {
        if (!camposValidos())
            return;
        Aluno aluno = montaAluno();

        try {
			//controller.insert(aluno);
            Toast.makeText(view.getContext(), "Aluno Inserido com Sucesso", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        limparCampos();
    }

    // Método para buscar
    private void buscar() {
        String id = editTextId.getText().toString().trim();

        if (id.isEmpty()) {
            Toast.makeText(view.getContext(), "Digite o ID conforme Tabela", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            //.findOne(aluno);
            if (aluno != null) {
                //preencheCampos(aluno);
            } else {
                Toast.makeText(view.getContext(), "Aluno não Encontrado", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Método para Listar
    private void listar() {
        try {
            //List < Aluno > alunos = alunoController.findALL();
            StringBuffer buffer = new StringBuffer();
            for (Aluno a: alunos) {
                buffer.append(a.toString() + "\n");
                buffer.append("____________________________________\n");
            }

            tvResultado.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Método para apagar
    private void apagar() {
        if (!camposValidos())
            return;
        Aluno aluno = montaAluno();
        try {
            //alunoController.delete(aluno);
            Toast.makeText(view.getContext(), "Aluno Apagado com Sucesso", Toast.LENGTH_SHORT).show();
            listar();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        limparCampos();
    }

    // Método para editar
    private void editar() {
        if (!camposValidos())
            return;
        Aluno aluno = montaAluno();

        try {
            //alunoController.update(aluno);
            Toast.makeText(view.getContext(), "Aluno Atualizado com Sucesso", Toast.LENGTH_SHORT).show();
            listar();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        limparCampos();
    }

    private Aluno montaAluno() {
		String RA = editTextRA.getText().toString().trim();
        String nome = editTextNome.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        // Cria um novo objeto Aluno com os valores extraídos da tela
        Aluno aluno = new Aluno();
        aluno.setRA(Integer.parseInt(RA));
		aluno.setNome(nome);
		aluno.setEmail(email);

        return aluno;
    }

    private void preencheCampos(Aluno aluno) {
		editTextRA.setText(String.valueOf(aluno.getRA()));
        editTextNome.setText(aluno.getNome());
		editTextEmail.setText(aluno.getEmail());
    }

    // Método para limpar os campos
    private void limparCampos() {
        editTextRA.setText("");
		editTextNome.setText("");
		editTextEmail.setText("");
    }

    // Método para verificar se todos os campos estão preenchidos
    private boolean camposValidos() {
		String RA = editTextRA.getText().toString().trim();
        String nome = editTextNome.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        // Verifica se algum campo está vazio
        if (nome.isEmpty() || RA.isEmpty() || email.isEmpty()) {
            Toast.makeText(view.getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
	*/
}