package BasicCalculatorOov1;

import javax.swing.JOptionPane;

public class Calculator {

    public static void main(String[] args) {

        while (true) {
            int number1 = EntryExit.infonum1();
            int number2 = EntryExit.infonum2();
            int acao = EntryExit.infop();
            String msg = " ";
            double dResult = 0;
            switch (acao) {
            case 1:
                dResult = number1 + number2;
                msg = "A soma é:";
                break;
            case 2:
                dResult = number1 - number2;
                msg = "A subtração é:";
                break;
            case 3:
                dResult = number1 * number2;
                msg = "A multiplicação é:";
                break;
            case 4:
                if (number2 != 0) {
                    dResult = number1 / number2;
                    msg = "A divisão é:";
                } else {
                    dResult = 999999999.9999;
                    msg = "Erro de divisão por zero";
                }
                break;
            case 5:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            EntryExit.showResult(msg + dResult);

        }

    }

}