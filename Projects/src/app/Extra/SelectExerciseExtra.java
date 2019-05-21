package app.Extra;

import javax.swing.JOptionPane;

public class SelectExerciseExtra {
    public SelectExerciseExtra(Integer exerciseOption) {
        switch (exerciseOption) {
        case 1:
            new BiggerAndSmaller();
            break;
        case 2:
            new Vector();
            break;
        case 3:
            new Average();
            break;
        case 4:
            new SelectLineInMatrix();
            break;
        case 5:
            // arrumar - 2 daniel - 1 jean - 1 0  - 1 qualquer
            new EletronicBallot();
            break;
        default:
            JOptionPane.showMessageDialog(null, "Você digitou um exerciou que não existe");
            exerciseOption = Integer.parseInt(JOptionPane.showInputDialog("Informe um exercicio"));
            new SelectExerciseExtra(exerciseOption);
            break;
        }
    }
}