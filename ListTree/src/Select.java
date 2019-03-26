import javax.swing.JOptionPane;

public class Select {
	private Float number01 = 0f;
	private Float number02 = 0f;

	public Select() {
		requestNumbers();
		showOptions();
		selectOption();
	}

	private void requestNumbers() {
		boolean isException;
		do {
			try {
				this.number01 = Float.parseFloat(JOptionPane.showInputDialog("Digite o 1° número"));
				this.number02 = Float.parseFloat(JOptionPane.showInputDialog("Digite o 2° número"));
				isException = false;
			} catch (Exception e) {
				System.out.println(e);
				isException = true;
			}
		} while (isException == true);
	}

	private void showOptions() {
		System.out.println("O que você quer fazer com esses números?");
		System.out.println("a - Verificar se os números são múltiplos de 3");
		System.out.println("b - Verificar se os dois números lidos são pares");
		System.out.println("c - Verificar se a média dos dois números é maior ou igual a 7");
		System.out.println("d - Sair");
	}

	private void selectOption() {
		String option;
		boolean exit = false;
		do {
			option = JOptionPane.showInputDialog("Informe a letra da alternativa que deseja executar");

			switch (option) {
			case "a":
				multipleOfTree(number01, number02);
				break;
			case "b":
				isEven(number01, number02);
				break;
			case "c":
				average(number01, number02);
				break;
			case "d":
				exit = true;
				break;
			default:
				System.out.print("Valor não encontrado");
				break;
			}
		} while (exit == false);
	}

	private void average(Float number1, Float number2) {
		if ((number1 + number2) / 2 > 7) {
			JOptionPane.showMessageDialog(null, "A média é maior ou igual a 7");
		} else {
			JOptionPane.showMessageDialog(null, "A média é menor que 7");
		}
	}

	private void isEven(Float number1, Float number2) {
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
	}

	private void multipleOfTree(Float number1, Float number2) {
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
	}

}
