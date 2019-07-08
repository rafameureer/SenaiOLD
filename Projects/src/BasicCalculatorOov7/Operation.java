package BasicCalculatorOov7;

/**
 * Operation
 */
public abstract class Operation implements Ioperation {
    protected int m_number1;
    protected int m_number2;

    public void adjustValue(int num1, int num2) {
        m_number1 = num1;
        m_number2 = num2;
    }

    abstract public String calculate();
}