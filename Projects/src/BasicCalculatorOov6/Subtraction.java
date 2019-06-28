package BasicCalculatorOov6;

/**
 * Subtraction
 */
public class Subtraction extends Operation {

    public Subtraction() {
        m_number1 = 0;
        m_number2 = 0;
    }

    public String calculate() {
        int dRestult = 0;
        String msg = "";
        dRestult = m_number1 - m_number2;
        msg = "A subtração é : " + dRestult;
        return msg;
    }
}