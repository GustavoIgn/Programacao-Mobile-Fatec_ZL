package br.edu.fateczl.ex_14;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.edu.fateczl.ex_14.controller.*;
import br.edu.fateczl.ex_14.model.Retangulo;

/*
@author: <Gustavo da Silva Ignacio 1110482313006>
*/

public class FragmentRetangulo extends Fragment {
    private EditText editTextBase, editTextAltura;
    private TextView textViewResultado;
    private GeometriaRetanguloController geometriaController = new GeometriaRetanguloController();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retangulo, container, false);

        editTextBase = view.findViewById(R.id.editTextBase);
        editTextAltura = view.findViewById(R.id.editTextAltura);
        textViewResultado = view.findViewById(R.id.textViewResultado);
        Button buttonCalcularArea = view.findViewById(R.id.buttonCalcularArea);
        Button buttonCalcularPerimetro = view.findViewById(R.id.btnCalcularPerimetro);

        buttonCalcularArea.setOnClickListener(v -> calcularArea());
        buttonCalcularPerimetro.setOnClickListener(v -> calcularPerimetro());

        return view;
    }

    private void calcularArea() {
        String baseString = editTextBase.getText().toString();
	String alturaString = editTextAltura.getText().toString();

	
	if (!baseString.isEmpty() && !alturaString.isEmpty()) {
            float base = Float.parseFloat(baseString);
            float altura = Float.parseFloat(alturaString);

            Retangulo retangulo = new Retangulo();
            retangulo.setBase(base);
            retangulo.setAltura(altura);
            float area = geometriaController.calcularArea(retangulo);
            textViewResultado.setText("Área: " + area);
            limparCampos();
	} else {
            textViewResultado.setText("Insira todos os valores");
        }
    }

    private void calcularPerimetro() {
	String baseString = editTextBase.getText().toString();
	String alturaString = editTextAltura.getText().toString();

	
	if (!baseString.isEmpty() && !alturaString.isEmpty()) {
            float base = Float.parseFloat(baseString);
            float altura = Float.parseFloat(alturaString);

            Retangulo retangulo = new Retangulo();
            retangulo.setBase(base);
            retangulo.setAltura(altura);

            float perimetro = geometriaController.calcularPerimetro(retangulo);
            textViewResultado.setText("Perímetro: " + perimetro);
            limparCampos();
        } else {
            textViewResultado.setText("Insira todos os valores");
        }
   }



    private void limparCampos() {
        editTextBase.setText("");
        editTextAltura.setText("");
    }
}
