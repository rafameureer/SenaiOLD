package app.ListOne;

import javax.swing.JOptionPane;

public class ApplesProgram {

	public ApplesProgram() {

		int quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantas maçãs foram compradas: "));
		Double result;
		if (quantity < 12) {
			result = quantity * 1.30;
		} else {
			result = quantity * 1.00;
		}

		JOptionPane.showMessageDialog(null,
				"Você comprou " + quantity + " maças no valor total de " + result + " reais");
	}

}
