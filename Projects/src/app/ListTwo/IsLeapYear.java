package app.ListTwo;

import javax.swing.JOptionPane;

public class IsLeapYear {

	public IsLeapYear() {
		int year = Integer.parseInt(JOptionPane.showInputDialog("Digite um ano, 4 digitos: "));
		while (year <= 999) {
			year = Integer.parseInt(JOptionPane.showInputDialog("Precisa ter 4 digitos. Digite um ano"));
		}

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			JOptionPane.showMessageDialog(null, "O ano " + year + " é bissexto");
		} else {
			JOptionPane.showMessageDialog(null, "O ano " + year + " não é bissexto");
		}
	}

}
