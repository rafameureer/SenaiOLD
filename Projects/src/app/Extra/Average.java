package app.Extra;

import javax.swing.JOptionPane;

public class Average {
    public Average() {
        Float average = this.calcAverage();
        this.response(average);

    }

    private Float calcAverage() {
        Float[] grades = new Float[4];
        Float average = 0f;

        for (int i = 0; i < grades.length; i++) {
            do {
                try {
                    grades[i] = Float.parseFloat(JOptionPane.showInputDialog("Informe a " + (i + 1) + "° nota"));
                    average += grades[i];
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (grades[i] < 0f);
        }

        average /= 4f;
        return average;
    }

    private void response(Float average) {
        if (average >= 9f) {
            JOptionPane.showMessageDialog(null, "O conceito do aluno é A com a média " + average);
        } else if (average >= 8f) {
            JOptionPane.showMessageDialog(null, "O conceito do aluno é B com a média " + average);

        } else if (average >= 7f) {
            JOptionPane.showMessageDialog(null, "O conceito do aluno é C com a média " + average);

        } else if (average < 7f) {
            JOptionPane.showMessageDialog(null, "O conceito do aluno é D com a média " + average);

        } else {
            JOptionPane.showMessageDialog(null, "Houve um problema ao calcular a média tente novamente");
        }
    }
}