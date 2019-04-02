package app.Extra;

import javax.swing.JOptionPane;

public class Vector {
    public Vector() {
        Integer vectorLength = setVectorLength();

        Float[] numbers = setVector(vectorLength);

        Float sumLastPositions = numbers[numbers.length - 1] + numbers[numbers.length - 2];

        if (numbers[0] < sumLastPositions) {
            FirstIsSmall(numbers, sumLastPositions);
        } else if (numbers[0].compareTo(sumLastPositions) == 0) {
            JOptionPane.showMessageDialog(null,
                    "O primeiro numero " + numbers[0] + " é igual a soma dos dois ultimos que é " + sumLastPositions);
        }

    }

    private Integer setVectorLength() {
        Integer vectorLength = 0;

        try {
            vectorLength = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor"));

            while (vectorLength <= 1) {
                vectorLength = Integer
                        .parseInt(JOptionPane.showInputDialog("O tamanho do vetor precisa ser maior que 1"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return vectorLength;
    }

    private Float[] setVector(Integer vetorLength) {
        Float[] numbers = new Float[vetorLength];

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

    private void FirstIsSmall(Float[] numbers, Float sumLastPositions) {
        Float small = numbers[0];
        small = this.setSmall(numbers[numbers.length - 1], small);
        small = this.setSmall(numbers[numbers.length - 2], small);
        JOptionPane.showMessageDialog(null, "O primeiro valor é " + numbers[0] + " e a soma dos dois ultimos é "
                + sumLastPositions + ", o menor entre eles é o " + small);
    }

    private Float setSmall(Float number, Float small) {
        return number < small ? number : small;
    }
}