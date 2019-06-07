package app.ListTree;

import javax.swing.JOptionPane;

public class Number02 {
	float[] notes = new float[3];
	int[] weight = new int[3];

	public Number02() {

		String averageType = JOptionPane.showInputDialog("Digite A para aritmética ou P para ponderada.");

		averageType = this.requestAverageType(averageType);

		this.requestNotesAndWeight(averageType);

		if (averageType.equals("A")) {
			this.arithmeticAverage(this.notes);
		} else {
			this.weightedAverage(this.notes, this.weight);
		}
	}

	private String requestAverageType(String averageType) {
		while (!averageType.equals("A") && !averageType.equals("P")) {
			averageType = JOptionPane.showInputDialog(
					"Você precisa escolher uma opção para seguir em frente. Digite A para aritmética ou P para ponderada.");
		}
		return averageType;
	}

	private void requestNotesAndWeight(String averageType) {
		int sumWeight = 0;

		for (int i = 0; i < this.notes.length; i++) {
			this.requestNotes(i);
			if (averageType.equals("P")) {
				sumWeight += this.weight[i];
				this.requestWeight(i, sumWeight);
			}
			while (this.notes[i] > 10 || this.notes[i] < 0) {
				this.requestNotes(i);
			}
		}
	}

	private void requestWeight(int i, int sumWeight) {
		int sumWeightOriginal = sumWeight;
		this.weight[i] = Integer.parseInt(JOptionPane.showInputDialog("Qual o peso dessa nota"));
		sumWeight += this.weight[i];

		if (sumWeight > 10) {
			this.requestWeight(i, sumWeightOriginal);
		} else if (sumWeight < 10 && i == 2) {
			this.requestWeight(i, sumWeightOriginal);
		} else if (sumWeight > 8 && i == 0) {
			this.requestWeight(i, sumWeightOriginal);
		} else if (sumWeight > 9 && i == 1) {
			this.requestWeight(i, sumWeightOriginal);
		}
	}

	private void requestNotes(int i) {
		boolean exception = false;
		do {
			try {
				this.notes[i] = Float.parseFloat(JOptionPane.showInputDialog(
						"Digite a " + (i + 1) + "° nota, lembrando que ela precisa estar entre 0 e 10"));
				exception = false;
			} catch (Exception e) {
				exception = true;
				System.out.println(e);
			}
		} while (exception);
	}

	private void weightedAverage(float[] notes, int[] weight) {
		int smPesos = 0;
		float average = 0F;
		for (int i = 0; i < notes.length; i++) {
			average += notes[i] * weight[i];
			smPesos += weight[i];
		}
		average /= smPesos;
		this.createResponse(average);
	}

	private void arithmeticAverage(float[] notes) {
		float average = 0F;
		for (int i = 0; i < notes.length; i++) {
			average += notes[i];
		}
		average = average / 3;
		this.createResponse(average);
	}

	private void createResponse(float average) {
		if (average >= 7) {
			JOptionPane.showMessageDialog(null, "O aluno esta aprovado com a média " + average);
		} else {
			JOptionPane.showMessageDialog(null, "O aluno esta reprovado com a média " + average);
		}
	}

}
