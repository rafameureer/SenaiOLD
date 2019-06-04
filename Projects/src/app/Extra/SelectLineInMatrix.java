package app.Extra;

import javax.swing.JOptionPane;

public class SelectLineInMatrix {
    public SelectLineInMatrix() {
        Integer[][] matrix = new Integer[3][3];
        for (int line = 0; line < matrix.length; line++) {
            for (int column = 0; column < matrix[line].length; column++) {
                Boolean exception = false;
                do {
                    try {
                        matrix[line][column] = Integer.parseInt(JOptionPane.showInputDialog(
                                "Informe o numero na linha " + (line + 1) + " e coluna " + (column + 1)));
                        exception = false;
                    } catch (Exception e) {
                        System.out.println(e);
                        exception = true;
                    }
                } while (exception);
            }
        }

        Integer selectedLine = Integer.parseInt(JOptionPane.showInputDialog("Qual linha você deseja ver ? (1, 2 ou 3)"))
                - 1;

        while (selectedLine + 1 <= 0 || selectedLine + 1 >= 4) {
            try {
                JOptionPane.showMessageDialog(null, "Você informou uma linha que não existe");
                selectedLine = Integer.parseInt(JOptionPane.showInputDialog("Qual linha você deseja ver ? (1, 2 ou 3)"))
                        - 1;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        for (int column = 0; column < matrix[selectedLine].length; column++) {
            // mostrar a matriz inteira
            JOptionPane.showMessageDialog(null, matrix[selectedLine][column] + "|");
        }
    }
}