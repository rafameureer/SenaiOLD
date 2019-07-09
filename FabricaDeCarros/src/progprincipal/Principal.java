package progprincipal;

import javax.swing.JOptionPane;

import classesobjetoscarro.Fabrica;

/**
 * Principal
 */
public class Principal {

    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();
        while (true) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n" + "1 - Vender carro\n"
                    + "2 - Fabricar carro\n" + "3 - Mostrar os carros\n" + "4 - Sair"));
            switch (acao) {
            case 1:
                String modelo = JOptionPane.showInputDialog("Qual o modelo do carro");
                fabrica.venderCarro(modelo, null);
                break;
            case 2:
                int quantidadeCarros = Integer
                        .parseInt(JOptionPane.showInputDialog("Quantos carros deseja fabricar ?"));
                fabrica.fabricarCarro(quantidadeCarros);
                break;
            case 3:
                fabrica.mostrarCarros();
                break;
            case 4:
                System.exit(1);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Você informou uma opção invalida");
                break;
            }
        }
    }
}