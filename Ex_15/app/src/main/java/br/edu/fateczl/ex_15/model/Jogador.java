package br.edu.fateczl.ex_15.model;

import java.time.LocalDate;

/*
@author<Gustavo da Silva Ignacio 111082313006>
*/

public class Jogador {
    private int id;
    private String nome;
    private LocalDate dataNasc;
    private float peso;
    private float altura;
    private Time time;

    public Jogador() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNasc=" + dataNasc +
                ", peso=" + peso +
                ", altura=" + altura +
                ", time=" + time +
                '}';
    }
}
