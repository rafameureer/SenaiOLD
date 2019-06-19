package BasicCalculatorOov4;

import javax.swing.JOptionPane;

import BasicCalculatorOov1.EntryExit;

public class Calculator {

    public static void main(String[] args) {

        while (true) {

            int numero1 = EntryExit.infonum1();
            int numero2 = EntryExit.infonum2();
            int acao = EntryExit.infop();

            String msg = calcular(numero1, numero2, acao);
            EntryExit.showResult(msg);

        }

    }

    private static String calcular(int numero1, int numero2, int operacao) {

        String mens = "";

        switch (operacao) {
        case 1:
            Sum sum = new Sum();
            mens = sum.calcular(numero1, numero2);
            break;
        case 2:
            Subtraction sub = new Subtraction();
            mens = sub.calcular(numero1, numero2);
            break;
        case 3:
            Multiplication multi = new Multiplication();
            mens = multi.calcular(numero1, numero2);
            break;
        case 4:
            Division divi = new Division();
            mens = divi.calcular(numero1, numero2);
            break;
        case 5:
            System.exit(0);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opção Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
            break;
        }

        return mens;

    }
}