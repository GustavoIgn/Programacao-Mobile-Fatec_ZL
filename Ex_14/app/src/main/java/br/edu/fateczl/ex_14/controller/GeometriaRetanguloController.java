package br.edu.fateczl.ex_14.controller;

import br.edu.fateczl.ex_14.model.Retangulo;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public class GeometriaRetanguloController implements IGeometriaController<Retangulo> {

    @Override
    public float calcularArea(Retangulo retangulo) {
        // Área do retângulo: base * altura
        return retangulo.getBase() * retangulo.getAltura();
    }

    @Override
    public float calcularPerimetro(Retangulo retangulo) {
        // Perímetro do retângulo: 2 * (base + altura)
        return 2 * (retangulo.getBase() + retangulo.getAltura());
    }
}
