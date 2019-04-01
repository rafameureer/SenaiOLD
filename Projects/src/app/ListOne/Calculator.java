package app.ListOne;

import javax.swing.JOptionPane;

public class Calculator {

	public Calculator() {

		int primaryValue = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor: "));
		float total = primaryValue;
		String r = "";

		do {
			String operation = JOptionPane.showInputDialog("Qual o calculo que deseja fazer ? Opções: +, -, /, * ");
			float value = Integer.parseInt(JOptionPane.showInputDialog("Digite o proximo valor: "));
			r = JOptionPane.showInputDialog("Quer continuar ?");

			if (operation.equals("+")) {
				total += value;
			} else if (operation.equals("/")) {
				total /= value;
			} else if (operation.equals("-")) {
				total -= value;
			} else if (operation.equals("*")) {
				total *= value;
			} else {
				JOptionPane.showMessageDialog(null, "Você digitou uma operação invalida" + operation);
			}
		} while (r.equals("sim"));

		JOptionPane.showMessageDialog(null, "O resultado final é: " + total);
	}

}
