package app.Extra;

import javax.swing.JOptionPane;

public class BiggerAndSmaller {
    private Integer smaller = 0;
    private Integer bigger = 0;

    public BiggerAndSmaller() {
        Boolean exception = false;
        Integer num1 = 0;
        Integer num2 = 0;
        Integer num3 = 0;
        do {
            try {
                num1 = this.requestNumber(1, num1);
                num2 = this.requestNumber(2, num2);
                num3 = this.requestNumber(3, num3);
                exception = false;
            } catch (Exception e) {
                System.out.println(e);
                exception = true;
            }
        } while (exception);

        JOptionPane.showMessageDialog(null, "Menor multiplcado pelo maior: " + this.smaller * this.bigger);
        JOptionPane.showMessageDialog(null, "Maior dividido pelo menor: " + this.bigger / this.smaller);
    }

    public Integer requestNumber(Integer position, Integer number) {
        Integer num = 0;
        if (number <= 0) {
            num = Integer.parseInt(JOptionPane.showInputDialog("Informe " + position + "° numero positivo e inteiro"));
            while (num <= 0) {
                num = Integer.parseInt(
                        JOptionPane.showInputDialog("O numero precisa ser inteiro e positivo, tente outra vez"));

            }
            this.bigger = num >= this.bigger || position == 1 ? num : this.bigger;
            this.smaller = num <= this.smaller || position == 1 ? num : this.smaller;
        }
        return number > 0 ? number : num;
    }
}