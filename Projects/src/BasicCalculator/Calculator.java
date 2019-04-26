package BasicCalculator;

import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) throws Exception {
        while (true) {
            int number1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o primeiro número: "));
            int number2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o segundo número: "));

            int action = Integer.parseInt(JOptionPane.showInputDialog("Escolha um cálculo básico: \n" + " 1 - Soma \n"
                    + "2 - Subtração \n" + "3 - Multiplicação \n" + "4 - Divisão \n" + "5 - Sair \n"));
            String msg = " ";
            double dResult = 0;

            switch (action) {

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
                    dResult = 999999999.999999999;
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

            showResult(msg + dResult);

        }
    }

    static void showResult(String recmsgdresult) {
        JOptionPane.showMessageDialog(null, recmsgdresult, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}