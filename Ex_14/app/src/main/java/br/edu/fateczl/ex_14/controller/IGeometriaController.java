package br.edu.fateczl.ex_14.controller;

import br.edu.fateczl.ex_14.model.Circulo;
import br.edu.fateczl.ex_14.model.Retangulo;

/*
@author<Gustavo da Silva Ignacio 111082313006>
*/

public interface IGeometriaController<T> {
    float calcularArea(T forma);
    float calcularPerimetro(T forma);
}
