package BasicCalculatorOov6;

/**
 * Sum
 */
public class Sum extends Operation {

    public Sum() {
        m_number1 = 0;
        m_number2 = 0;
    }

    public String calculate() {
        int dRestult = 0;
        String msg = "";
        dRestult = m_number1 + m_number2;
        msg = "A soma é : " + dRestult;
        return msg;
    }
}