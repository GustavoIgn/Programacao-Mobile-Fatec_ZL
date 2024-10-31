package br.edu.fateczl.ex_13.model;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

public class OutroAtleta extends Atleta {

    private String academia;
    private double recorde;

    public OutroAtleta() {
        super();
    }

    public OutroAtleta(String nome, String dataNascimento, String bairro, String academia, double recorde) {
        super(nome, dataNascimento, bairro);
        this.academia = academia;
        this.recorde = recorde;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public double getRecorde() {
        return recorde;
    }

    public void setRecorde(double recorde) {
        this.recorde = recorde;
    }

    @Override
    public String toString() {
        return super.toString() + ", academia='" + academia + '\'' + ", recorde=" + recorde + '}';
    }
}