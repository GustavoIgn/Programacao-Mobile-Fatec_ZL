package br.edu.fateczl.ex_13.controller;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import java.util.ArrayList;
import java.util.List;


import br.edu.fateczl.ex_13.model.OutroAtleta;

public class OperacaoOutro implements IOperacaoAtleta<OutroAtleta> {

    private static OperacaoOutro instance;
    List<OutroAtleta> lista;


    public OperacaoOutro() {
        this.lista = new ArrayList<>();
    }

    public static OperacaoOutro getInstance() {
        if (instance == null) {
            instance = new OperacaoOutro();
        }
        return instance;
    }

    @Override
    public void cadastrar(OutroAtleta outroAtleta) {
        lista.add(outroAtleta);
    }


    @Override
    public List<OutroAtleta> listar() {
        return this.lista;
    }
}
