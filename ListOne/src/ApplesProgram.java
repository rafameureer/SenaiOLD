import javax.swing.JOptionPane;

public class ApplesProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantas maçãs foram compradas: "));
		Double result;
		if (quantity < 12) {
			result = quantity * 1.30;
		} else {
			result = quantity * 1.00;
		}

		JOptionPane.showMessageDialog(null, "Você comprou " + quantity + " maças no valor total de " + result + " reais");
	}

}
