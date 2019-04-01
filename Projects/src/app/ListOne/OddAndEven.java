package app.ListOne;

import javax.swing.JOptionPane;

public class OddAndEven {

	public OddAndEven() {

		int[] numbers = new int[10];
		int quantityOdd = 0;
		int quantityEven = 0;
		int sumEven = 0;
		int sumOdd = 0;

		for (int i = 0; i < 10; i++) {
			int position = i + 1;
			numbers[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um número " + position + "/10:"));

			if (numbers[i] % 2 == 0) {
				quantityEven += 1;
				sumEven += numbers[i];
			} else {
				quantityOdd += 1;
				sumOdd += numbers[i];
			}
		}

		JOptionPane.showMessageDialog(null,
				"Você digitou " + quantityEven + " números pares e " + quantityOdd + " números ímpares");
		JOptionPane.showMessageDialog(null, "A soma dos pares é " + sumEven + " e a soma dos ímpares é " + sumOdd);

	}

}
