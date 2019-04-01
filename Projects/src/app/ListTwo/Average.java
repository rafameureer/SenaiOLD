package app.ListTwo;

import javax.swing.JOptionPane;

public class Average {
	// Implementado o while para o studentsQauntity e para o grades
	public Average() {
		int studentsQuantity = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos a turma tem ? "));
		while (studentsQuantity <= 0) {
			studentsQuantity = Integer.parseInt(JOptionPane
					.showInputDialog("A turma precis ter pelo menos 1 aluno. Quantos alunos a turma tem ? "));
		}
		Float classAverage = 0f;

		Students[] students = new Students[studentsQuantity];
		for (int i = 0; i < studentsQuantity; i++) {
			students[i] = new Students();
			for (int j = 0; j < 3; j++) {
				students[i].grades[j] = Float.parseFloat(JOptionPane
						.showInputDialog("Digite a nota do aluno " + (i + 1) + " no " + (j + 1) + "° trimestre:"));
				students[i].average += students[i].grades[j];
				while (students[i].grades[j] < 0) {
					students[i].grades[j] = Float.parseFloat(
							JOptionPane.showInputDialog("A nota não pode ser abaixo de 0. Digite a nota do aluno "
									+ (i + 1) + " no " + (j + 1) + "° trimestre:"));
				}
			}
			students[i].average /= 3;
			classAverage += students[i].average;
		}
		classAverage /= studentsQuantity;
		JOptionPane.showMessageDialog(null, "A média da turma é :" + classAverage);
	}

}

class Students {
	String name = "";
	Float[] grades = new Float[3];
	Float average = 0f;
}
