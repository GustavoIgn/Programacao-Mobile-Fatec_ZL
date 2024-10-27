package br.edu.fateczl.ex_11.model;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public class IngressoVip extends Ingressos {
    public String funcaoDono;

    public IngressoVip(String codId, float valor, String funcaoDono) {
        super(codId, valor);
        this.funcaoDono = funcaoDono;
    }

    @Override
    public float valorFinal(float valorTaxaConveniencia) {
        float valorBase = super.valorFinal(valorTaxaConveniencia);

        return valorBase * 1.18f;
    }

}