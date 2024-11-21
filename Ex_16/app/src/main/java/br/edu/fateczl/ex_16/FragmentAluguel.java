package br.edu.fateczl.ex_16;

/*
@author: <Gustavo da Silva Ignacio 1110482313006>
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import android.database.SQLException;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.fateczl.ex_16.model.Aluguel;
import br.edu.fateczl.ex_16.model.Aluno;
import br.edu.fateczl.ex_16.model.Exemplar;

public class FragmentAluguel extends Fragment {

    private EditText editTextDataRetirada;
    private EditText editTextDataDevolucao;
    private Button buttonSalvar,
    buttonApagar,
    buttonEditar,
    buttonListar,
    buttonBuscar;
    private TextView tvResultado;
    private Spinner spAlunos;
    private Spinner spExemplares;
    private View view;

    public FragmentAluguel() {
        super();
    }

     @ Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_aluguel, container, false);

        // Inicialização dos campos e botões
        spAlunos = view.findViewById(R.id.spAlunos);
        spExemplares = view.findViewById(R.id.spExemplares);
        editTextDataRetirada = view.findViewById(R.id.editTextDataRetirada);
        editTextDataDevolucao = view.findViewById(R.id.editTextDataDevolucao);

        buttonSalvar = view.findViewById(R.id.buttonSalvar);
        buttonListar = view.findViewById(R.id.buttonListar);
        buttonApagar = view.findViewById(R.id.buttonApagar);
        buttonEditar = view.findViewById(R.id.buttonEditar);
        buttonBuscar = view.findViewById(R.id.buttonBuscar);
        tvResultado = view.findViewById(R.id.tvListaAlugueis);
        tvResultado.setMovementMethod(new ScrollingMovementMethod());
		
		tvResultado.setText("Exemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\nExemplo ------------------------------------------------------------------------------------------\n");

        /*preencheSpinner();

        // Configuração dos botões
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

        Aluguel aluguel = montaAluguel();
        try {
            // controller.insert(aluguel);
            Toast.makeText(view.getContext(), "Aluguel Inserido com Sucesso", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        limparCampos();
    }

    // Método para buscar
    private void buscar() {
        String ra = editTextRA.getText().toString().trim();

        if (ra.isEmpty()) {
            Toast.makeText(view.getContext(), "Digite o RA do aluno", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Aluguel aluguel = controller.findOne(ra);
            if (aluguel != null) {
                //preencheCampos(aluguel);
            } else {
                Toast.makeText(view.getContext(), "Aluguel não encontrado", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Método para listar
    private void listar() {
        try {
            // List<Aluguel> alugueis = controller.findAll();
            StringBuilder buffer = new StringBuilder();
            for (Aluguel a: alugueis) {
                buffer.append(a.toString()).append("\n");
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

        Aluguel aluguel = montaAluguel();
        try {
            // controller.delete(aluguel);
            Toast.makeText(view.getContext(), "Aluguel Apagado com Sucesso", Toast.LENGTH_SHORT).show();
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

        Aluguel aluguel = montaAluguel();
        try {
            // controller.update(aluguel);
            Toast.makeText(view.getContext(), "Aluguel Atualizado com Sucesso", Toast.LENGTH_SHORT).show();
            listar();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        limparCampos();
    }

    private Aluguel montaAluguel() {
        String ra = editTextRA.getText().toString().trim();
        String exemplarId = editTextExemplarId.getText().toString().trim();
        String dataRetirada = editTextDataRetirada.getText().toString().trim();
        String dataDevolucao = editTextDataDevolucao.getText().toString().trim();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Aluguel aluguel = new Aluguel();
        aluguel.setAluno(new Aluno(Integer.parseInt(ra))); // Criar instância baseada no RA
        aluguel.setExemplar(new Exemplar(Integer.parseInt(exemplarId))); // Criar instância baseada no ID do exemplar
        aluguel.setDataRetirada(LocalDate.parse(dataRetirada, formatter));
        aluguel.setDataDevolucao(LocalDate.parse(dataDevolucao, formatter));

        return aluguel;
    }

    private void preencheCampos(Aluguel aluguel) {
        editTextRA.setText(String.valueOf(aluguel.getAluno().getRA()));
        editTextExemplarId.setText(String.valueOf(aluguel.getExemplar().getId()));
        editTextDataRetirada.setText(aluguel.getDataRetirada().toString());
        editTextDataDevolucao.setText(aluguel.getDataDevolucao().toString());
    }

    // Método para limpar os campos
    private void limparCampos() {
        editTextRA.setText("");
        editTextExemplarId.setText("");
        editTextDataRetirada.setText("");
        editTextDataDevolucao.setText("");
    }

    // Método para verificar se todos os campos estão preenchidos
    private boolean camposValidos() {
        String ra = editTextRA.getText().toString().trim();
        String exemplarId = editTextExemplarId.getText().toString().trim();
        String dataRetirada = editTextDataRetirada.getText().toString().trim();
        String dataDevolucao = editTextDataDevolucao.getText().toString().trim();

        if (ra.isEmpty() || exemplarId.isEmpty() || dataRetirada.isEmpty() || dataDevolucao.isEmpty()) {
            Toast.makeText(view.getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void preencheSpinner() {
        // Preenchendo Spinner de Alunos
        //List < Aluno > alunos = alunoCont.findAll();
        List < String > alunoDisplayList = new ArrayList <  > ();
        alunoDisplayList.add("Escolha um Aluno");

        for (Aluno aluno: alunos) {
            alunoDisplayList.add("RA= " + aluno.getRA() + " | Nome= " + aluno.getNome());
        }

        ArrayAdapter < String > alunoAdapter = new ArrayAdapter <  > (getContext(), android.R.layout.simple_spinner_item, alunoDisplayList);
        alunoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAlunos.setAdapter(alunoAdapter);

        spAlunos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @ Override
            public void onItemSelected(AdapterView <  ?  > parent, View view, int position, long id) {
                if (position > 0) {
                    String alunoText = alunoDisplayList.get(position);
                    int alunoRA = Integer.parseInt(alunoText.split("=")[1].split(" \\|")[0].trim());
                    //Aluno alunoSelecionado = alunoCont.findOne(alunoRA);
                    Toast.makeText(getContext(), "Aluno Selecionado: " + alunoSelecionado.getNome(), Toast.LENGTH_SHORT).show();
                }
            }

             @ Override
            public void onNothingSelected(AdapterView <  ?  > parent) {}
        });

        // Preenchendo Spinner de Exemplares
        //List < Exemplar > exemplares = exemplarCont.findAll();
        List < String > exemplarDisplayList = new ArrayList <  > ();
        exemplarDisplayList.add("Escolha um Exemplar");

        for (Exemplar exemplar : exemplares) {
            exemplarDisplayList.add("ID= " + exemplar.getCodigo() + " | Nome= " + exemplar.getNome());
        }

        ArrayAdapter < String > exemplarAdapter = new ArrayAdapter <  > (getContext(), android.R.layout.simple_spinner_item, exemplarDisplayList);
        exemplarAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spExemplares.setAdapter(exemplarAdapter);

        spExemplares.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @ Override
            public void onItemSelected(AdapterView <  ?  > parent, View view, int position, long id) {
                if (position > 0) {
                    String exemplarText = exemplarDisplayList.get(position);
                    int exemplarID = Integer.parseInt(exemplarText.split("=")[1].split(" \\|")[0].trim());
                    //Exemplar exemplarSelecionado = exemplarCont.findOne(exemplarID);
                    Toast.makeText(getContext(), "Exemplar Selecionado: " + exemplarSelecionado.getNome(), Toast.LENGTH_SHORT).show();
                }
            }

             @ Override
            public void onNothingSelected(AdapterView <  ?  > parent) {}
        });
    }
	*/
}
