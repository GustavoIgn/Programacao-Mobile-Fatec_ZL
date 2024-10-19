package br.edu.fateczl.ex_9.model;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public class ProfessorHorista extends Professor {
    private int horasAula;
    private double valorHoraAula;

    public ProfessorHorista(String nome, String matricula, int idade, int horasAula, double valorHoraAula) {
        super(nome, matricula, idade);
        this.horasAula = horasAula;
        this.valorHoraAula = valorHoraAula;
    }

    // Getters e Setters
    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    // Implementação do cálculo do salário como horasAula * valorHoraAula
    @Override
    public double calcSalario() {
        return horasAula * valorHoraAula;
    }
}
