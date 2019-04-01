package app.ListOne;

import javax.swing.JOptionPane;
import java.util.Random;

public class TargetShooting {

	public TargetShooting() {

		Random random = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(50);
			System.out.println(numbers[i]);
		}

		int number = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero: "));

		int response = searchNumber(number, numbers);

		if (response >= 0) {
			JOptionPane.showMessageDialog(null, "O numero existe na posição " + response);
		} else {
			JOptionPane.showMessageDialog(null, "O numero " + number + " não existe");
		}

	}

	public static int searchNumber(int number, int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == number) {
				return i;
			}
		}
		return -1;
	}

}
