package BasicCalculatorOov7;

public class Multiplication extends Operation {

    public Multiplication() {
        m_number1 = 0;
        m_number2 = 0;
    }

    public String calculate() {
        int dRestult = 0;
        String msg = "";
        dRestult = m_number1 * m_number2;
        msg = "A multiplicação é : " + dRestult;
        return msg;
    }
}