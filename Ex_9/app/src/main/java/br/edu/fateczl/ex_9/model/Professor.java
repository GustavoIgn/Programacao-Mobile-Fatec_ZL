package br.edu.fateczl.ex_9.model;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public abstract class Professor {
    protected String nome;
    protected String matricula;
    protected int idade;

    public Professor(String nome, String matricula, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método abstrato para calcular o salário
    public abstract double calcSalario();
}
