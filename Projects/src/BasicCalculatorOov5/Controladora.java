package BasicCalculatorOov5;

import javax.swing.JOptionPane;

import BasicCalculatorOov4.Division;
import BasicCalculatorOov4.Multiplication;
import BasicCalculatorOov4.Subtraction;
import BasicCalculatorOov4.Sum;

public class Controladora {

	public String calcular(int numero1, int numero2, int operacao) {

		String mens = "";
		switch (operacao) {
		case 1:
			Sum soma = new Sum();
			mens = soma.calcular(numero1, numero2);
			break;
		case 2:
			Subtraction sub = new Subtraction();
			mens = sub.calcular(numero1, numero2);
			break;
		case 3:
			Multiplication multi = new Multiplication();
			mens = multi.calcular(numero1, numero2);
			break;
		case 4:
			Division divi = new Division();
			mens = divi.calcular(numero1, numero2);
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
