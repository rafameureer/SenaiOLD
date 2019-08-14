package objetosConta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Conta
 */
public class Conta {

    private String titularDaConta;
    private int tipo;
    private float saldo;
    private List<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();

    /**
     * @return the listaDeMovimentacao
     */
    public List<Movimentacao> getListaDeMovimentacao() {
        return listaDeMovimentacao;
    }

    /**
     * @param listaDeMovimentacao the listaDeMovimentacao to set
     */
    public void setListaDeMovimentacao(List<Movimentacao> listaDeMovimentacao) {
        this.listaDeMovimentacao = listaDeMovimentacao;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the titularDaConta
     */
    public String getTitularDaConta() {
        return titularDaConta;
    }

    /**
     * @param titularDaConta the titularDaConta to set
     */
    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

    public String depositar(float valor) {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(new Date());
        movimentacao.setTipo(2);
        movimentacao.setValor(valor);
        this.listaDeMovimentacao.add(movimentacao);
        this.saldo += valor;
        return "Valor R$" + valor + " depositado\n" + "Seu saldo atual é R$" + this.saldo;
    }

    public String sacar(float valor) {
        String message = "";
        if (this.saldo > -1000 && this.saldo - valor >= -1000) {
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setData(new Date());
            movimentacao.setTipo(1);
            movimentacao.setValor(valor);
            this.listaDeMovimentacao.add(movimentacao);
            this.saldo -= valor;
            message = "Valor R$" + valor + " sacado\n" + "Seu saldo atual é R$" + this.saldo;
        } else {
            message = "Seu saldo não permite que você faça mais saques, seu saldo atual é: " + this.saldo;
        }
        return message;
    }

    public String gerarExtrato() {
        String extrato = "";
        int posicaoDeposito = 1;
        int posicaoSaque = 1;
        if (this.listaDeMovimentacao.isEmpty()) {
            extrato = "A lista de movimentação esta vazia";
        } else {
            for (Movimentacao movimentacao : this.listaDeMovimentacao) {
                if (movimentacao.getTipo() == 1) {
                    extrato += "Saque " + posicaoSaque + "\n" + "Data: " + movimentacao.getData() + "\n" + "Valor: "
                            + movimentacao.getValor() + "\n";
                    posicaoSaque++;
                } else {
                    extrato += "Deposito " + posicaoDeposito + "\n" + "Data: " + movimentacao.getData() + "\n"
                            + "Valor: " + movimentacao.getValor() + "\n";
                    posicaoDeposito++;
                }
            }
        }
        return extrato;
    }

    public String gerarExtratoDeposito() {
        String extrato = "";
        int position = 1;
        for (Movimentacao movimentacao : this.listaDeMovimentacao) {
            if (movimentacao.getTipo() == 2) {
                extrato += "Deposito " + position + "\n" + "Data: " + movimentacao.getData() + "\n" + "Valor: "
                        + movimentacao.getValor() + "\n";
                position++;
            }
        }
        return extrato;
    }

    public String gerarExtratoSaques() {
        String extrato = "";
        int position = 1;
        for (Movimentacao movimentacao : this.listaDeMovimentacao) {
            if (movimentacao.getTipo() == 1) {
                extrato += "Saque " + position + "\n" + "Data: " + movimentacao.getData() + "\n" + "Valor: "
                        + movimentacao.getValor() + "\n";
                position++;
            }
        }
        return extrato;
    }

    public void iniciarConta(String titular, int tipo) {
        this.titularDaConta = titular;
        this.tipo = tipo;
        this.saldo = 0;
    }

}