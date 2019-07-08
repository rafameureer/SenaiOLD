package interfacegrafica;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import classesobjetoscasa.Casa;
import classesobjetoscasa.Janela;
import classesobjetoscasa.Porta;

/**
 * MenuOpcoes
 */
public class MenuOpcoes {
    public void exibirMenu() {
        Casa casa = new Casa();

        while (true) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma opção: \n"
                    + "1 - Construir casa\n"
                    + "2 - Pintar a casa\n"
                    + "3 - Mover Porta(s)\n"
                    + "4 - Mover Janela(s)\n"
                    + "5 - Informações da casa\n"
                    + "6 - Sair"));

            switch (acao) {
            case 1:
                dadosConstCasa(casa);
                break;
            case 2:
                pintarCasa(casa);
                break;
            case 3:
                moverPorta(casa);
                break;
            case 4:
                moverJanela(casa);
                break;
            case 5:
                mostrarInformacoes(casa);
                break;
            case 6:
                System.exit(1);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
                ;
                break;
            }
        }
    }

    private void mostrarInformacoes(Casa casa) {
        String descricao = casa.getDescricao();
        String cor = casa.getCor();
        String portas = "";
        String janelas = "";
        for (Porta porta : casa.getListaDePortas()) {
            String status = this.formatStatus(porta.getStatus());
            portas += "Descrição: " + porta.getIdentificacao() + "\nStatus: " + status + "\n";
        }
        for (Janela janela : casa.getListaDeJanelas()) {
            String status = this.formatStatus(janela.getStatus());
            janelas += "Descrição: " + janela.getIdentificacao() + "\nStatus: " + status + "\n";
        }
        JOptionPane.showMessageDialog(null,
                "Casa: " + descricao + "\nCor: " + cor + "\nPortas: \n" + portas + "Janelas:\n" + janelas);
    }

    private String formatStatus(int statusNumero) {
        String status = "";
        if (statusNumero == 1) {
            status = "Aberta";
        } else {
            status = "Fechada";
        }
        return status;
    }

    private void moverPorta(Casa casa) {
        if (casa.getListaDePortas() == null) {
            JOptionPane.showMessageDialog(null, "A casa não tem Porta(s)!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "A casa tem Porta(s)!", "ok", JOptionPane.INFORMATION_MESSAGE);
            List list = new ArrayList();

            for (Porta porta : casa.getListaDePortas()) {
                list.add(porta.getIdentificacao());
            }

            JComboBox field1 = new JComboBox(list.toArray());
            String[] listStatus = { "Aberta", "Fechada" };
            JComboBox field2 = new JComboBox(listStatus);

            Object[] message = { "Porta: ", field1, "Status: ", field2 };
            int option = JOptionPane.showConfirmDialog(null, message, "Porta", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                int status;
                if (field2.getSelectedIndex() == 0) {
                    status = 1;
                } else {
                    status = 2;
                }
                casa.movimentarPorta(field1.getSelectedIndex(), status);
            }
        }
    }

    private void moverJanela(Casa casa) {
        if (casa.getListaDeJanelas() == null) {
            JOptionPane.showMessageDialog(null, "A casa não tem Janela(s)!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "A casa tem Janela(s)!", "ok", JOptionPane.INFORMATION_MESSAGE);
            List list = new ArrayList();

            for (Janela janela : casa.getListaDeJanelas()) {
                list.add(janela.getIdentificacao());
            }

            JComboBox field1 = new JComboBox(list.toArray());
            String[] listStatus = { "Aberta", "Fechada" };
            JComboBox field2 = new JComboBox(listStatus);

            Object[] message = { "Janela: ", field1, "Status: ", field2 };
            int option = JOptionPane.showConfirmDialog(null, message, "Janela", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                int status;
                if (field2.getSelectedIndex() == 0) {
                    status = 1;
                } else {
                    status = 2;
                }
                casa.movimentarJanela(field1.getSelectedIndex(), status);
            }
        }
    }

    private void pintarCasa(Casa casa) {
        String cor = JOptionPane.showInputDialog("Digite a cor da casa");
        casa.pintarCasa(cor);
    }

    private void dadosConstCasa(Casa casa) {
        String descricao = JOptionPane.showInputDialog("Descrição da casa: ");
        String cor = JOptionPane.showInputDialog("Informe a cor da casa: ");
        int portas = Integer.parseInt(JOptionPane.showInputDialog("Informe quantas portas: "));
        int janelas = Integer.parseInt(JOptionPane.showInputDialog("Informe quantas janelas: "));

        List<Janela> listaDeJanelas = new ArrayList();
        List<Porta> listaDePortas = new ArrayList();

        for (int i = 0; i < janelas; i++) {
            listaDeJanelas.add(solicitarJanelas(i));
        }

        for (int i = 0; i < portas; i++) {
            listaDePortas.add(solicitarPortas(i));
        }

        // casa.setDescricao(descricao);
        // casa.setCor(cor);
        // casa.setListaDeJanelas(listaDeJanelas);
        // casa.setListaDePortas(listaDePortas);

        casa.construirCasa(descricao, cor, listaDeJanelas, listaDePortas);

        System.out.println(casa.getDescricao());
        System.out.println(casa.getCor());

        for (Janela janela : casa.getListaDeJanelas()) {
            System.out.println("Descrição: " + janela.getIdentificacao());
            System.out.println("Situação: " + janela.getStatus());
        }

        for (Porta porta : casa.getListaDePortas()) {
            System.out.println("Descrição: " + porta.getIdentificacao());
            System.out.println("Situação: " + porta.getStatus());
        }
    }

    private Porta solicitarPortas(int i) {
        Porta porta = new Porta();
        i++;
        String identificacao = JOptionPane.showInputDialog("Digite a descrição da porta " + i + ": ");
        int status = Integer.parseInt(JOptionPane
                .showInputDialog("Digite o status da porta " + identificacao + "\n 1 Para aberta \n 2 Para fechada:"));
        porta.setIdentificacao(identificacao);
        porta.setStatus(status);

        System.out.print("Porta: " + i + " Descrição: " + identificacao + " Status: " + status);

        return porta;
    }

    private Janela solicitarJanelas(int i) {
        Janela janela = new Janela();
        i++;
        String identificacao = JOptionPane.showInputDialog("Digite a descrição da janela " + i + ": ");
        int status = Integer.parseInt(JOptionPane
                .showInputDialog("Digite o status da janela " + identificacao + "\n 1 Para aberta \n 2 Para fechada:"));

        janela.setIdentificacao(identificacao);
        janela.setStatus(status);

        // System.out.print("Janela: " + i + " Descrição:" + identificacao + " Status: "
        // + status);

        return janela;
    }
}