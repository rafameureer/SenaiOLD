package BasicCalculatorOov1;

import javax.swing.JOptionPane;

public class EntryExit {
    public static int infonum1() {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o primeiro número"));
        return num1;
    }

    public static int infonum2() {
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o segundo número"));
        return num2;
    }

    public static int infop() {
        int op = Integer.parseInt(JOptionPane.showInputDialog("Escolha um cálculo básico: \n" + " 1 - Soma \n"
                + "2 - Subtração \n" + "3 - Multiplicação \n" + "4 - Divisão \n" + "5 - Sair \n"));
        return op;
    }

    public static void showResult(String recmsgdresult) {
        JOptionPane.showMessageDialog(null, recmsgdresult, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}