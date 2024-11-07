package br.edu.fateczl.ex_15;

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

import br.edu.fateczl.ex_15.controller.*;
import br.edu.fateczl.ex_15.model.*;

public class FragmentTime extends Fragment {
    private EditText editTextRaio;
    private TextView textViewResultado;
    private GeometriaCirculoController geometriaController = new GeometriaCirculoController();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

    }

    private void limparCampos() {
        editTextRaio.setText("");
    }
}
