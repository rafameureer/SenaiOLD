import javax.swing.JOptionPane;

public class SepareteOddAndEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String evenResult = "";
		String oddResult = "";

		for (int i = 10; i <= 50; i++) {
			if (i % 2 == 0) {
				// Alterar para remover a virgula no final
				evenResult += ", " + String.valueOf(i);
			} else {
				// Alterar para remover a virgula no final
				oddResult += ", " + String.valueOf(i);
			}
		}
		
		oddResult = oddResult.replaceFirst(", ", "");
		evenResult = evenResult.replaceFirst(", ", "");
		
		JOptionPane.showMessageDialog(null, "Pares: " + evenResult);
		JOptionPane.showMessageDialog(null, "Ímpares: " + oddResult);

	}

}
