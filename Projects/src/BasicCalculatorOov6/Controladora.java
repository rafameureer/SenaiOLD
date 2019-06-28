package BasicCalculatorOov6;

import javax.swing.JOptionPane;

public class Controladora {

	public String calcular(int numero1, int numero2, int operacao) {

		String mens = "";
		switch (operacao) {
		case 1:
			Sum sum = new Sum();
			sum.adjustValue(numero1, numero2);
			mens = sum.calculate();
			break;
		case 2:
			Subtraction sub = new Subtraction();
			sub.adjustValue(numero1, numero2);
			mens = sub.calculate();
			break;
		case 3:
			Multiplication multi = new Multiplication();
			multi.adjustValue(numero1, numero2);
			mens = multi.calculate();
			break;
		case 4:
			Division division = new Division();
			division.adjustValue(numero1, numero2);
			mens = division.calculate();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		return mens;

	}
}