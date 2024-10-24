package br.edu.fateczl.ex_10.model;

/*
@author:<Gustavo da Silva Ignacio 111082313006>
 */

public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial(String cliente, int num_conta, float saldoInicial, float limite) {
        super(cliente, num_conta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(float valor) {
        if (valor <= getSaldo() + limite) {
            depositar(-valor); // Permite saque até o limite
            return true; // Indica que o saque foi bem-sucedido
        } else {
            System.out.println("Valor excede o limite da conta especial.");
            return false; // Indica que o saque falhou
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Limite: " + limite;
    }
}
