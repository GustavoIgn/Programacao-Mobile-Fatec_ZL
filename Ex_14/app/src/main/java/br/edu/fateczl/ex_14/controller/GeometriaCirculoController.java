package br.edu.fateczl.ex_14.controller;

import br.edu.fateczl.ex_14.model.Circulo;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public class GeometriaCirculoController implements IGeometriaController<Circulo> {

    private static final float PI = 3.14159f;

    @Override
    public float calcularArea(Circulo circulo) {
        // Área do círculo: pi * raio * raio
        float raio = circulo.getRaio();
        return PI * raio * raio;
    }

    @Override
    public float calcularPerimetro(Circulo circulo) {
        // Perímetro do círculo: 2 * pi * raio
        float raio = circulo.getRaio();
        return 2 * PI * raio;
    }
}

