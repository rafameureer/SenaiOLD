package app.ListTree;

import javax.swing.JOptionPane;

public class Select {
	private Integer number01 = 0;
	private Integer number02 = 0;

	public Select() {
		requestNumbers();
		selectOption();
	}

	private void requestNumbers() {
		boolean isException;
		do {
			try {
				this.number01 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1° número"));
				this.number02 = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2° número"));
				isException = false;
			} catch (Exception e) {
				System.out.println(e);
				isException = true;
			}
		} while (isException == true);
	}

	private void selectOption() {
		String option;
		boolean exit = false;
		do {
			option = JOptionPane.showInputDialog(
					"O que você quer fazer com esses números? \n a - Verificar se os números são múltiplos de 3 \n b - Verificar se os dois números lidos são pares \n c - Verificar se a média dos dois números é maior ou igual a 7 \n d - Sair \n Informe a letra da alternativa que deseja executar");
			System.out.print(option);
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
				this.exit();
				break;
			default:
				System.out.print("Valor não encontrado");
				break;
			}
		} while (exit == false);
	}

	private void exit() {
		System.exit(0);
	}

	private void average(Integer number1, Integer number2) {
		if ((number1 + number2) / 2 > 7) {
			JOptionPane.showMessageDialog(null, "A média é maior ou igual a 7");
		} else {
			JOptionPane.showMessageDialog(null, "A média é menor que 7");
		}
	}

	private void isEven(Integer number1, Integer number2) {
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

	private void multipleOfTree(Integer number1, Integer number2) {
		// Float[] exemplo = { number1, number2 };
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
