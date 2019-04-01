package app.ListTwo;

import javax.swing.JOptionPane;

public class HigherPositionLowerPosition {

	public HigherPositionLowerPosition() {
		int quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantos números você quer digitar"));
		while (quantity <= 0) {
			quantity = Integer.parseInt(JOptionPane
					.showInputDialog("Você precisa digitar pelo menos 1 numero. Quantos números você quer digitar"));
		} // Alterado para while
		int[] numbers = new int[quantity];
		NumberAndPosition higher = new NumberAndPosition();
		NumberAndPosition lower = new NumberAndPosition();

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um número maior que 0"));
			while (numbers[i] <= 0) {
				numbers[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um número maior que 0"));
			}
			// Alterar para utilizar um valor do array
			if (numbers[i] >= higher.number || i == 0) {
				higher.number = numbers[i];
				higher.position = i;
			}

			if (numbers[i] <= lower.number || i == 0) {
				lower.number = numbers[i];
				lower.position = i;
			}
		}

		JOptionPane.showMessageDialog(null,
				"O maior valor é " + higher.number + " e está na posição " + higher.position);

		JOptionPane.showMessageDialog(null, "O menor valor é " + lower.number + " e está na posição " + lower.position);
	}
}

class NumberAndPosition {
	int position;
	int number;
}
