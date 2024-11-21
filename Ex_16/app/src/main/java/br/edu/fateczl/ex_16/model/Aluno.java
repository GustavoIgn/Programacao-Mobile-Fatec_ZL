package br.edu.fateczl.ex_16.model;

/*
@author:<Gustavo da Silva Ignácio 1110482313006>
 */

public class Aluno {

    private int RA;
    private String nome;
    private String email;

    public Aluno() {}

    public int getRA() {
        return this.RA;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setRA(int valor) {
        this.RA = valor;
    }

    public void setNome(String valor) {
        this.nome = valor;
    }

    public void setEmail(String valor) {
        this.email = valor;
    }

     @ Override
    public String toString() {
        return "Aluno{" +
        "RA=" + RA +
        ", nome='" + nome + '\'' +
        ", email='" + email + '\'' +
        '}';
    }
}
