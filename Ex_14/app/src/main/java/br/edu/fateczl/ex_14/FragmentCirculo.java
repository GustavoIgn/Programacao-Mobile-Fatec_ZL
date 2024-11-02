package br.edu.fateczl.ex_14;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.edu.fateczl.ex_14.controller.*;
import br.edu.fateczl.ex_14.model.Circulo;

public class FragmentCirculo extends Fragment {
    private EditText editTextRaio;
    private TextView textViewResultado;
    private GeometriaCirculoController geometriaController = new GeometriaCirculoController();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circulo, container, false);

        editTextRaio = view.findViewById(R.id.editTextRaio);
        textViewResultado = view.findViewById(R.id.textViewResultado);
        Button buttonCalcularArea = view.findViewById(R.id.buttonCalcularArea);
        Button buttonCalcularPerimetro = view.findViewById(R.id.btnCalcularPerimetro);

        buttonCalcularArea.setOnClickListener(v -> calcularArea());
        buttonCalcularPerimetro.setOnClickListener(v -> calcularPerimetro());

        return view;
    }

    private void calcularArea() {
	String raioString = editTextRaio.getText().toString();
	if (!raioString.isEmpty()) {
            float raio = Float.parseFloat(raioString);
            Circulo circulo = new Circulo();
            circulo.setRaio(raio);

            float area = geometriaController.calcularArea(circulo);
            textViewResultado.setText("Área: " + area);
            limparCampos();
	} else {
            textViewResultado.setText("Insira todos os valores");
        }
    }

    private void calcularPerimetro() {
        String raioString = editTextRaio.getText().toString();
	if (!raioString.isEmpty()) {
            float raio = Float.parseFloat(raioString);
            Circulo circulo = new Circulo();
            circulo.setRaio(raio);

            float perimetro = geometriaController.calcularPerimetro(circulo);
             textViewResultado.setText("Perímetro: " + perimetro);
             limparCampos();
    	} else {
            textViewResultado.setText("Insira todos os valores");
        }
    }

    private void limparCampos() {
        editTextRaio.setText("");
    }
}
