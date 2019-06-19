package BasicCalculatorOov4;

/**
 * Division
 */
public class Division {

    public String calcular(int num1, int num2) {
        int dRestult = 0;
        String msg = "";
        if (num2 != 0) {
            dRestult = num1 / num2;
            msg = "A divisão é : " + dRestult;
        } else {
            dRestult = 9999999;
            msg = "Erro de divisão por zero";

        }
        return msg;
    }
}