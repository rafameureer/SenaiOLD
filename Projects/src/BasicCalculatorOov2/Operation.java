package BasicCalculatorOov2;

import javax.swing.JOptionPane;

public class Operation {

    public String calculate(int number1, int number2, int action) {
        String msg = "";
        double dResult = 0;
        switch (action) {
        case 1:
            dResult = number1 + number2;
            msg = "A soma é: ";
            break;
        case 2:
            dResult = number1 - number2;
            msg = "A subtração é: ";
            break;
        case 3:
            dResult = number1 * number2;
            msg = "A multiplicação é: ";
            break;
        case 4:
            if (number2 != 0) {
                dResult = number1 / number2;
                msg = "A divisão é: ";
            } else {
                dResult = 999999999.999999999;
                msg = "Erro na divisão por zero ";
            }
            break;
        case 5:
            System.exit(0);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opção Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
            break;
        }

        return (msg + dResult);
    }

}