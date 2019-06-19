package BasicCalculatorOov4;

/**
 * Multiplication
 */
public class Multiplication {

    public String calcular(int num1, int num2) {
        int dRestult = 0;
        String msg = "";
        dRestult = num1 * num2;
        msg = "A multiplicação é : " + dRestult;
        return msg;
    }
}