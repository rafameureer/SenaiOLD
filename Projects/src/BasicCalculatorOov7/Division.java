package BasicCalculatorOov7;

/**
 * Division
 */
public class Division extends Operation {

    public Division() {
        m_number1 = 0;
        m_number2 = 0;
    }

    public String calculate() {
        int dRestult = 0;
        String msg = "";
        if (m_number2 != 0) {
            dRestult = m_number1 / m_number2;
            msg = "A divisão é : " + dRestult;
        } else {
            dRestult = 9999999;
            msg = "Erro de divisão por zero";

        }
        return msg;
    }
}