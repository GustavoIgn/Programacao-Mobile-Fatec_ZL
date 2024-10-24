package br.edu.fateczl.ex_10.model;
/*
@author:<Gustavo da Silva Ignacio 1110482313006>
 */

public class ContaBancaria {
    protected String cliente;
    protected int num_Conta;
    protected float saldo;

    public ContaBancaria(String cliente, int numConta, float saldoInicial) {
        this.cliente = cliente;
        this.num_Conta = numConta;
        this.saldo = saldoInicial;
    }

    public boolean sacar(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    public float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + ", Conta: " + num_Conta + ", Saldo: " + saldo;
    }
}
