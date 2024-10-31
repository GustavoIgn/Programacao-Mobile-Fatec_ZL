package br.edu.fateczl.ex_13.controller;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import java.util.List;

public interface IOperacaoAtleta<T> {
    void cadastrar(T t);
    List<T> listar();
}