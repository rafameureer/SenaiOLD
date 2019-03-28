import javax.swing.JOptionPane;

public class Select {

	public static void main(String[] args) {

		Float number1 = 0f;
		Float number2 = 0f;
		boolean exit = false;
		String[] options = new String[4];
		String selected = "";
		options[0] = "Verificar se os números são múltiplos de 3";
		options[1] = "Verificar se os dois números lidos são pares";
		options[2] = "Verificar se a média dos dois números é maior ou igual a 7";
		options[3] = "Sair";

		number1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o 1° número"));
		number2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o 2° número"));

		do {
			selected = String.valueOf(JOptionPane.showInputDialog(null, "Escolha uma das opções", "Select",
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]));

			switch (selected) {
			case "Verificar se os números são múltiplos de 3":

				if (number1 % 3 == 0) {
					JOptionPane.showMessageDialog(null, "O primeiro numero é multiplo de 3");
				} else {
					JOptionPane.showMessageDialog(null, "O primeiro numero não é multiplo de 3");
				}

				if (number2 % 3 == 0) {
					JOptionPane.showMessageDialog(null, "O segundo numero é multiplo de 3");
				} else {
					JOptionPane.showMessageDialog(null, "O segundo numero não é multiplo de 3");
				}

				break;
			case "Verificar se os dois números lidos são pares":

				if (number1 % 2 == 0) {
					JOptionPane.showMessageDialog(null, "O primeiro numero é par");
				} else {
					JOptionPane.showMessageDialog(null, "O primeiro numero não é par");
				}

				if (number2 % 2 == 0) {
					JOptionPane.showMessageDialog(null, "O segundo numero é par");
				} else {
					JOptionPane.showMessageDialog(null, "O segundo numero não é par");
				}

				break;
			case "Verificar se a média dos dois números é maior ou igual a 7":

				if ((number1 + number2) / 2 > 7) {
					JOptionPane.showMessageDialog(null, "A média é maior ou igual a 7");
				} else {
					JOptionPane.showMessageDialog(null, "A média é menor que 7");
				}

				break;
			case "Sair":
				exit = true;
				break;
			default:
				System.out.print("Valor não encontrado");
				break;
			}
		} while (exit == false);
	}

}
