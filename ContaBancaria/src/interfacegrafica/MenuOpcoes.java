package interfacegrafica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import objetosConta.Conta;
import objetosConta.Movimentacao;

/**
 * MenuOpcoes
 */
public class MenuOpcoes {

    private List<Conta> contas = new ArrayList();

    public void exibirMenu() {
        while (true) {
            Conta conta = null;

            int acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n" + "1 - Deposito\n"
                    + "2 - Saque\n" + "3 - Dados da conta\n" + "4 - Extrato completo\n" + "5 - Extrato de depositos\n"
                    + "6 - Extrato de saques\n" + "7 - Criar Conta\n" + "8 - Sair"));
            if (acao != 7 && acao != 8) {
                conta = this.requisitarConta();
                if (conta.getTitularDaConta() == null) {
                    this.exibirMenu();
                }
            }
            switch (acao) {
            case 1:
                this.solicitarInformacoesDeposito(conta);
                break;
            case 2:
                this.solicitarInformacoesSaque(conta);
                break;
            case 3:
                this.exibirDadosDaConta(conta);
                break;
            case 4:
                this.exibirExtratoCompleto(conta);
                break;
            case 5:
                this.exibirExtratoDeDepositos(conta);
                break;
            case 6:
                this.exibirExtratoDeSaques(conta);
                break;
            case 7:
                this.criarConta();
                break;
            case 8:
                System.exit(1);
                break;
            default:
                break;
            }
        }
    }

    private Conta requisitarConta() {
        String nomeTitular = JOptionPane.showInputDialog("Nome do titular:");
        Conta conta = this.encontrarConta(nomeTitular);
        return conta;
    }

    private void criarConta() {
        Conta conta = new Conta();
        String titular = JOptionPane.showInputDialog("Informe o nome do titular da conta");
        int tipo = Integer.parseInt(JOptionPane
                .showInputDialog("Informe o tipo de conta\n" + "1 - Conta poupança\n" + "2 - Conta corrente\n"));
        conta.iniciarConta(titular, tipo);
        contas.add(conta);
    }

    public void solicitarInformacoesDeposito(Conta conta) {
        float valor = this.requisitarValor("Informe o valor que deseja depositar:");
        String message = conta.depositar(valor);
        JOptionPane.showMessageDialog(null, message);
    }

    private float requisitarValor(String message) {
        float valor = Float.parseFloat(JOptionPane.showInputDialog(message));
        while (valor <= 0) {
            valor = Float.parseFloat(JOptionPane.showInputDialog(
                    "Informe o valor que deseja depositar, ele não pode ser igual ou menor que zero:"));
        }
        return valor;
    }

    public void solicitarInformacoesSaque(Conta conta) {
        float valor = this.requisitarValor("Informe o valor que deseja sacar:");
        String message = conta.sacar(valor);
        JOptionPane.showMessageDialog(null, message);
    }

    private Conta encontrarConta(String nomeTitular) {
        Conta contaSelecionada = new Conta();
        for (Conta conta : this.contas) {
            if (conta.getTitularDaConta().equals(nomeTitular)) {
                contaSelecionada = conta;
            }
        }
        if (contaSelecionada.getTitularDaConta() == null) {
            JOptionPane.showMessageDialog(null, "Conta inexistente");
        }

        return contaSelecionada;
    }

    public void exibirDadosDaConta(Conta conta) {
        JOptionPane.showMessageDialog(null, "Nome do titular: " + conta.getTitularDaConta() + " Tipo: "
                + conta.getTipo() + " Saldo: " + conta.getSaldo());
    }

    public void exibirExtratoCompleto(Conta conta) {
        String extrato = conta.gerarExtrato();
        JOptionPane.showMessageDialog(null, extrato);
    }

    public void exibirExtratoDeDepositos(Conta conta) {
        this.exibirExtrato(conta, 2);
    }

    public void exibirExtratoDeSaques(Conta conta) {
        this.exibirExtrato(conta, 1);
    }

    private void exibirExtrato(Conta conta, int tipo) {
        String extrato = "";
        if (tipo == 1) {
            extrato = conta.gerarExtratoSaques();
        } else {
            extrato = conta.gerarExtratoDeposito();
        }
        JOptionPane.showMessageDialog(null, extrato);
    }
}