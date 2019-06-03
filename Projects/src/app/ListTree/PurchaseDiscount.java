package app.ListTree;

import javax.swing.JOptionPane;

public class PurchaseDiscount {
    private Float value;

    public PurchaseDiscount() {
        this.value = this.requestValue();
        this.selectOption();
    }

    private void selectOption() {
        if (this.value <= 100) {
            this.responseValuePurchase(0);
        } else if (this.value > 100 && this.value <= 200) {
            this.calcValue(5);
        } else if (this.value > 200 && this.value <= 500) {
            this.calcValue(10);
        } else {
            this.calcValue(15);
        }
    }

    private void responseValuePurchase(Integer discount) {
        //(int)variable
        if (discount > 0) {
            //método para formatar
            JOptionPane.showMessageDialog(null,
                    "O valor total da compra com o desconto de " + discount + "% é R$" + this.value + "0");
        } else {
            JOptionPane.showMessageDialog(null, "O valor da sua compra não tem desconto");
        }
    }

    private void calcValue(Integer discount) {
        Float d = Float.valueOf(discount);
        this.value = this.value - (this.value * (d / 100));
        this.responseValuePurchase(discount);
    }

    private Float requestValue() {
        Float value = 0f;
        do {
            try {
                value = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da sua compra"));
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (value <= 0);

        return value;
    }
}