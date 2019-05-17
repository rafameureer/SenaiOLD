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
            this.fiveDiscount();
        } else if (this.value > 200 && this.value <= 500) {
            this.tenDiscount();
        } else {
            this.fifteenDiscount();
        }
    }

    private void responseValuePurchase(Integer discount) {
        if (discount > 0) {
            JOptionPane.showMessageDialog(null,
                    "O valor total da compra com o desconto de " + discount + "% é R$" + this.value + "0");
        } else {
            JOptionPane.showMessageDialog(null, "O valor da sua compra não tem desconto");
        }
    }
    // arrumar para um metodo

    private void fifteenDiscount() {
        this.value = this.value - (this.value * 0.15f);
        this.responseValuePurchase(15);
    }

    private void tenDiscount() {
        this.value = this.value - (this.value * 0.1f);
        this.responseValuePurchase(10);
    }

    private void fiveDiscount() {
        this.value = this.value - (this.value * 0.05f);
        this.responseValuePurchase(5);
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