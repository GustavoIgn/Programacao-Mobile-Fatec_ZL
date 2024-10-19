package br.edu.fateczl.ex_9.model;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public class ProfessorTitular extends Professor {
    private int anosInstituicao;
    private double salario;

    public ProfessorTitular(String nome, String matricula, int idade, int anosInstituicao, double salario) {
        super(nome, matricula, idade);
        this.anosInstituicao = anosInstituicao;
        this.salario = salario;
    }

    // Getters e Setters
    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Implementação do cálculo do salário com aumento de 5% a cada 5 anos
    @Override
    public double calcSalario() {
        int quinquenios = anosInstituicao / 5;
        return salario * (1 + (quinquenios * 0.05));
    }
}
