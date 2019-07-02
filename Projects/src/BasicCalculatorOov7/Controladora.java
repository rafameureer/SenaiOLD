package BasicCalculatorOov7;

import javax.swing.JOptionPane;

/**
 * Comunicadora
 */
public class Controladora {

    public String calcular(int num1, int num2, int operation) {
        String mens = "";
        Operation oper = null;
        switch (operation) {
        case 1:
            Sum sum = new Sum();
            oper = sum;
            break;
        case 2:
            Subtraction sub = new Subtraction();
            oper = sub;
            break;
        case 3:
            Multiplication multi = new Multiplication();
            oper = multi;
            break;
        case 4:
            Division divi = new Division();
            oper = divi;
            break;
        case 5:
            System.exit(0);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opção Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
            break;
        }

        if (oper != null) {
            oper.adjustValue(num1, num2);
            mens = oper.calculate();
        }

        return mens;
    }
}