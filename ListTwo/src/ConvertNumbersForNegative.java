import javax.swing.JOptionPane;

public class ConvertNumbersForNegative {
	// Implementado o while para validar a quantidade
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantos números você deseja informar: "));
		while (quantity <= 0) {
			quantity = Integer.parseInt(JOptionPane.showInputDialog(
					"Você precisa informar pelo menos 1 numero. Quantos números você deseja informar: "));
		}
		int negativeNumbers = 0;

		int[] numbers = new int[quantity];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe um número: "));
			if (numbers[i] < 0) {
				negativeNumbers++;
			}
		}

		if (negativeNumbers == 1) {
			JOptionPane.showMessageDialog(null, "Você informou " + negativeNumbers + " número negativo");
		} else {
			JOptionPane.showMessageDialog(null, "Você informou " + negativeNumbers + " números negativos");
		}
	}
}
