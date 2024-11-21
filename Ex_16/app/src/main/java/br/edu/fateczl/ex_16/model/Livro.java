package br.edu.fateczl.ex_16.model;

/*
@author:<Gustavo da Silva Ignácio 1110482313006>
 */

public class Livro extends Exemplar {
    private String ISBN;
    private int edicao;

    public Livro() {}

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

     @ Override
    public String toString() {
        return "Livro{" +
        "ISBN='" + ISBN + '\'' +
        ", edicao=" + edicao +
        ", " + super.toString() +
        '}';
    }

}
