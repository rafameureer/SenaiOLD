package objetosConta;

import java.util.List;

/**
 * Conta
 */
public class Conta {

    private String titularDaConta;
    private int tipo;
    private float saldo;
    private List<Movimentacao> listaDeMovimentacao;

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

    public void depositar() {

    }

    public void sacar() {

    }

    public void consultarSaldo() {

    }

    public void gerarExtrato() {

    }

    public void gerarExtratoDeposito() {

    }

    public void gerarExtratoSaques() {

    }

    public void iniciarConta(String titular, int tipo) {
        this.titularDaConta = titular;
        this.tipo = tipo;
        this.saldo = 0;
    }

}