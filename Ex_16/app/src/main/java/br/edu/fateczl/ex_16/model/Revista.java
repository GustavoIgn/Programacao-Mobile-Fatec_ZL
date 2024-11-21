package br.edu.fateczl.ex_16.model;

/*
@author:<Gustavo da Silva Ignácio 1110482313006>
 */

public class Revista extends Exemplar {
    private String ISSN;

    public Revista() {}

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

     @ Override
    public String toString() {
        return "Revista{" +
        "ISSN='" + ISSN + '\'' +
        ", " + super.toString() +
        '}';
    }
}
