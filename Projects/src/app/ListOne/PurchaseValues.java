package app.ListOne;

import javax.swing.JOptionPane;

public class PurchaseValues {

	public PurchaseValues() {

		float totalValue = Integer.parseInt(JOptionPane.showInputDialog("Qual foi o valor total da sua compra: "));
		int plots = Integer.parseInt(JOptionPane.showInputDialog("Em quantas vezes você quer parcelar: "));
		float plotsValue = totalValue / plots;

		JOptionPane.showMessageDialog(null, "Sua compra foi de " + totalValue + " reais, você optou por parcelar em "
				+ plots + " vezes. Sua parcela mensal é de " + plotsValue + " reais");
	}

}
