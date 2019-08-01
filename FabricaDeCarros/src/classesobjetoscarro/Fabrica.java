package classesobjetoscarro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Fabrica
 */
public class Fabrica {
    private List<Carro> carros = new ArrayList<Carro>();

    public void venderCarro(String modelo, String cor) {
        if (carros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem carros no estoque", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            boolean corEncontrada = false;
            boolean modeloEncontrado = false;
            Carro carroVendido = new Carro();
            String corPossivel = "";
            for (Carro carro : carros) {
                if (carro.getModelo().equals(modelo)) {
                    modeloEncontrado = true;
                    if (cor == null) {
                        cor = JOptionPane.showInputDialog("Qual a cor do carro");
                    }
                    if (carro.getCor().equals(cor)) {
                        corEncontrada = true;
                        carroVendido = carro;
                    } else {
                        corPossivel = carro.getCor();
                        corEncontrada = false;
                    }
                } else {
                    modeloEncontrado = false;
                }
            }
            if (modeloEncontrado == false) {
                JOptionPane.showMessageDialog(null, "Não temos esse modelo");
            } else if (corEncontrada) {
                carros.remove(carroVendido);
                JOptionPane.showMessageDialog(null, "Carro vendido!");
            } else {
                int option = JOptionPane.showConfirmDialog(null,
                        "Não temos a cor que você digitou, pode ser a cor " + corPossivel + " ?");
                if (option == JOptionPane.OK_OPTION) {
                    this.venderCarro(modelo, corPossivel);
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena");
                }
            }
        }
    }

    public void fabricarCarro(int quantidadeCarros) {

        for (int i = 0; i < quantidadeCarros; i++) {
            Carro carro = new Carro();
            carro.setModelo(JOptionPane.showInputDialog("Qual o modelo do carro " + (i + 1)));
            carro.setCor(JOptionPane.showInputDialog("Qual a cor do carro " + (i + 1)));
            this.carros.add(carro);
        }
    }

    public void mostrarCarros() {
        if (this.carros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não temos carros no estoque");
        } else {
            String carros = "";
            for (Carro carro : this.carros) {
                carros += "Modelo: " + carro.getModelo() + " cor: " + carro.getCor() + "\n";
            }
            JOptionPane.showMessageDialog(null, carros);
        }
    }
}