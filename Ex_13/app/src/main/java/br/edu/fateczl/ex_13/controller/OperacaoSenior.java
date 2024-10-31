package br.edu.fateczl.ex_13.controller;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.ex_13.model.AtletaSenior;

public class OperacaoSenior implements IOperacaoAtleta<AtletaSenior> {

    private static OperacaoSenior instance;
    List<AtletaSenior> lista;

    public OperacaoSenior(){
        this.lista = new ArrayList<>();

    }

    public static OperacaoSenior getInstance() {
        if (instance == null) {
            instance = new OperacaoSenior();
        }
        return instance;
    }

    @Override
    public void cadastrar(AtletaSenior senior) {
        lista.add(senior);
    }

    @Override
    public List<AtletaSenior> listar() {
        return this.lista;
    }
}