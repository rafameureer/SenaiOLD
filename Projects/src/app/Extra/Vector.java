package app.Extra;

import javax.swing.JOptionPane;

public class Vector {
    public Vector() {
        try {
            Integer vetorLength = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor"));
            while (vetorLength <= 1) {
                vetorLength = Integer
                        .parseInt(JOptionPane.showInputDialog("O tamanho do vetor precisa ser maior que 1"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}