import javax.swing.JOptionPane;

public class Number09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int quantity;
		int quantityEquals = 0;
		String bigger = "";
		String smaller = "";
		String equals = "";
		int x;

		do {
			quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantas posições o array deve ter ? 0 ou maior"));
			x = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor de x, 0 ou maior "));
		} while (quantity <= 0 && x <= 0);

		int[] array = new int[quantity];
		// quantidade
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero " + (i + 1)));
			if (array[i] < x) {
				smaller += "posição " + i + " numero " + array[i] + " ";
			} else if (array[i] == x) {
				equals += "posição " + i + " numero " + array[i] + " ";
				quantityEquals += 1;
			} else if (array[i] > x) {
				bigger += "posição " + i + " numero " + array[i] + " ";
			}
		}

		if (bigger != "") {
			JOptionPane.showMessageDialog(null, "O(s) numero(s) maior(es) que o valor de x são: " + bigger);
		}
		if (smaller != "") {
			JOptionPane.showMessageDialog(null, "O(s) numero(s) menor(es) que o valor de x são: " + smaller);
		}
		if (quantityEquals > 0) {
			JOptionPane.showMessageDialog(null,
					"O(s) " + quantityEquals + " numero(s) iguai(s) que o valor de x são: " + equals);
		}

	}
}
