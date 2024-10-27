package br.edu.fateczl.ex_11.model;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public class Ingressos {
    public String codId;
    public float valor;

    public Ingressos(String codId, float valor) {
        this.codId = codId;
        this.valor = valor;
    }

    public float valorFinal(float valorTaxaConveniencia) {
        return this.valor + valorTaxaConveniencia;
    }
}
