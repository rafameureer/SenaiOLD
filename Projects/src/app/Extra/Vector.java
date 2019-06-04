package app.Extra;

import javax.swing.JOptionPane;

public class Vector {
    public Vector() {
        // não parar o programa
        Integer vectorLength = setVectorLength();

        float[] numbers = setVector(vectorLength);

        float sumLastPositions = numbers[numbers.length - 1] + numbers[numbers.length - 2];

        if (numbers[0] < sumLastPositions) {
            this.firstIsSmall(numbers, sumLastPositions);
        // } else if (numbers[0].compareTo(sumLastPositions) == 0) {
        } else if (numbers[0] == sumLastPositions) {
            JOptionPane.showMessageDialog(null,
                    "O primeiro numero " + numbers[0] + " é igual a soma dos dois ultimos que é " + sumLastPositions);
        }

    }

    private Integer setVectorLength() {
        Integer vectorLength = 0;

        try {
            vectorLength = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor"));

            while (vectorLength <= 2) {
                vectorLength = Integer
                        .parseInt(JOptionPane.showInputDialog("O tamanho do vetor precisa ser maior que 1"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return vectorLength;
    }

    private float[] setVector(Integer vetorLength) {
        float[] numbers = new float[vetorLength];

        for (int i = 0; i < numbers.length; i++) {
            do {
                try {
                    numbers[i] = Float.parseFloat(
                            JOptionPane.showInputDialog("Informe o " + (i + 1) + "° número positivo do vetor"));
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (numbers[i] <= 0f);
        }

        return numbers;
    }

    private void firstIsSmall(float[] numbers, float sumLastPositions) {
        float small = numbers[0];
        small = this.setSmall(numbers[numbers.length - 1], small);
        small = this.setSmall(numbers[numbers.length - 2], small);
        JOptionPane.showMessageDialog(null, "O primeiro valor é " + numbers[0] + " e a soma dos dois ultimos é "
                + sumLastPositions + ", o menor entre eles é o " + small);
    }

    private float setSmall(float number, float small) {
        return number < small ? number : small;
    }
}