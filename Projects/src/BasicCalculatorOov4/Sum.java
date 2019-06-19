package BasicCalculatorOov4;

/**
 * Sum
 */
public class Sum {
    public String calcular(int num1, int num2) {
        int dRestult = 0;
        String msg = "";
        dRestult = num1 + num2;
        msg = "A soma é : " + dRestult;
        return msg;
    }
}