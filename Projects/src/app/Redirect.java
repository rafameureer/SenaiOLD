package app;

import javax.swing.JOptionPane;

import app.Challenge.Challenge;
import app.Extra.SelectExerciseExtra;
import app.ListTree.SelectExerciseTree;
import app.ListTwo.SelectExerciseTwo;

public class Redirect {
    public Redirect() {
        Integer listOption = Integer.parseInt(JOptionPane.showInputDialog("Informe qual lista você deseja acessar"));
        Integer exerciseOption = Integer
                .parseInt(JOptionPane.showInputDialog("Informe qual exercicio você quer acessar"));

        switch (listOption) {
        case 1:
            this.findExerciseInListOne(exerciseOption);
            break;
        case 2:
            new SelectExerciseTwo(exerciseOption);
            break;
        case 3:
            new SelectExerciseTree(exerciseOption);
            break;
        case 4:
            new SelectExerciseExtra(exerciseOption);
            break;
        case 5:
            new Challenge();
            break;
        default:
            JOptionPane.showMessageDialog(null, "A opção selecionada não é valida, digite um numero de 1 a 4");
            break;
        }
    }

    private void findExerciseInListOne(Integer exerciseOption) {
        JOptionPane.showMessageDialog(null, "Opção ainda não implementada");
    }

}