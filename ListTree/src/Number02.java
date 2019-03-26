import javax.swing.JOptionPane;

public class Number02 {

	public Number02() {
		float[] notas = new float[3];
		int[] pesos = new int[3];

		String qualMedia = JOptionPane.showInputDialog("Digite A para aritmética ou P para ponderada.");

		while (!qualMedia.equals("A") && !qualMedia.equals("P")) {
			qualMedia = JOptionPane.showInputDialog(
					"Você precisa escolher uma opção para seguir em frente. Digite A para aritmética ou P para ponderada.");
		}

		for (int i = 0; i < notas.length; i++) {
			notas[i] = Float.parseFloat(JOptionPane.showInputDialog("nota"));
			if (qualMedia.equals("P")) {
				pesos[i] = Integer.parseInt(JOptionPane.showInputDialog("Qual o peso dessa nota"));
			}
		}

		if (qualMedia.equals("A")) {
			this.mediaAritmetica(notas);
		} else {
			this.mediaPonderada(notas, pesos);
		}
	}

	public void mediaPonderada(float[] notas, int[] pesos) {
		float media = 0F;
		for (int i = 0; i < notas.length; i++) {
			media += notas[i] * pesos[i];
		}
		media /= 3;
		this.createResponse(media);
	}

	public void mediaAritmetica(float[] notas) {
		float media = 0F;
		for (int i = 0; i < notas.length; i++) {
			media += notas[i];
		}
		media = media / 3;
		this.createResponse(media);
	}

	public void createResponse(float media) {
		if (media >= 7) {
			JOptionPane.showMessageDialog(null, "O aluno esta aprovado com a média " + media);
		} else {
			JOptionPane.showMessageDialog(null, "O aluno esta reprovado com a média " + media);
		}
	}

}
