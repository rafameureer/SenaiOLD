package BasicCalculatorOov4;

/**
 * Subtraction
 */
public class Subtraction {
    public String calcular(int num1, int num2) {
        int dRestult = 0;
        String msg = "";
        dRestult = num1 - num2;
        msg = "A subtração é : " + dRestult;
        return msg;
    }
}