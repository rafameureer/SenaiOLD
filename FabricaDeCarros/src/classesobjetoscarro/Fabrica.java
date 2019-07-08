package classesobjetoscarro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Fabrica
 */
public class Fabrica {
    private List<Carro> carros = new ArrayList();

    public void venderCarro(String modelo, String cor) {
        Carro carroVendido = new Carro();
        for (Carro carro : carros) {
            if (carro.getCor().equals(cor)) {
                if (carro.getModelo().equals(modelo)) {
                    carroVendido = carro;
                }
            }
        }
        carros.remove(carroVendido);

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
        String carros = "";
        for (Carro carro : this.carros) {
            carros += "Modelo: " + carro.getModelo() + " cor: " + carro.getCor() + "\n";
        }
        JOptionPane.showMessageDialog(null, carros);
    }
}