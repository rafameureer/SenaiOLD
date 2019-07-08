package interfacegrafica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import objetosConta.Conta;


public class MenuOpcoes {
    private List<Conta> contas = new ArrayList();

    public void exibirMenu() {
        int acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n" + "1 - Deposito\n"
                + "2 - Saque\n" + "3 - Dados da conta\n" + "4 - Extrato completo\n" + "5 - Extrato de depositos\n"
                + "6 - Extrato de saques\n" + "7 - Criar Conta" + "8 - Sair"));
        switch (acao) {
        case 1:
            this.solicitarInformacoesDeposito();
            break;
        case 2:
            this.solicitarInformacoesSaque();
            break;
        case 3:
            // this.exibirDadosDaConta();
            break;
        case 4:
            this.exibirExtratoCompleto();
            break;
        case 5:
            this.exibirExtratoDeDepositos();
            break;
        case 6:
            this.exibirExtratoDeSaques();
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

    private void criarConta() {
        Conta conta = new Conta();
        String titular = JOptionPane.showInputDialog("Informe o nome do titular da conta");
        int tipo = Integer.parseInt(JOptionPane
                .showInputDialog("Informe o tipo de conta\n" + "1 - Conta poupança\n" + "2 - Conta corrente\n"));
        conta.iniciarConta(titular, tipo);
        contas.add(conta);
    }

    public void solicitarInformacoesDeposito() {

    }

    public void solicitarInformacoesSaque() {

    }

    public void exibirDadosDaConta(String nomeTitular) {
        for (Conta conta : this.contas) {
            if (conta.getTitularDaConta() == nomeTitular) {
                JOptionPane.showMessageDialog(null, "Nome do titular: " + conta.getTitularDaConta() + " Tipo: "
                        + conta.getTipo() + " Saldo: " + conta.getSaldo());
            }
        }
    }

    public void exibirExtratoCompleto() {

    }

    public void exibirExtratoDeDepositos() {

    }

    public void exibirExtratoDeSaques() {

    }
}