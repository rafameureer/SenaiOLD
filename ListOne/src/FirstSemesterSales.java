import javax.swing.JOptionPane;

public class FirstSemesterSales {
	public static void main(String[] args) {
		float[][] matriz = new float[6][4];
		float total = 0;
		float[] totalMonth = new float[6];
		for (int i = 0; i <= matriz.length; i++) {
			for (int j = 0; j <= matriz[i].length; j++) {
				matriz[i][j] = Integer.parseInt(JOptionPane
						.showInputDialog("Qual o valor das vendas na semana " + (j + 1) + " do mês " + (i + 1) + ": "));
				total += matriz[i][j];
				totalMonth[i] += matriz[i][j];
			}
		}

		for (int i = 0; i <= totalMonth.length; i++) {
			JOptionPane.showMessageDialog(null, "O total de vendas do mês " + (i + 1) + " é: " + totalMonth[i]);
		}
		JOptionPane.showMessageDialog(null, "O total de vendas do semestre é: " + total);

	}
}
