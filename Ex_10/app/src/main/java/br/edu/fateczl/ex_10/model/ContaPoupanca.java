package br.edu.fateczl.ex_10.model;

/*
@author:<Gustavo da Silva Ignacio 111082313006>
 */

public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    public ContaPoupanca(String cliente, int num_conta, float saldoInicial, int diaRendimento) {
        super(cliente, num_conta, saldoInicial);
        this.diaRendimento = diaRendimento;
    }

    public void calcularNovoSaldo(float taxa) {
        float novoSaldo = getSaldo() + (getSaldo() * taxa);
        depositar(novoSaldo - getSaldo()); // Atualiza o saldo com o rendimento
    }

    @Override
    public String toString() {
        return super.toString() + ", Dia de Rendimento: " + diaRendimento;
    }
}
