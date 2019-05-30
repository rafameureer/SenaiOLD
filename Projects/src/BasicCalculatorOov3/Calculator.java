package BasicCalculatorOov3;

import BasicCalculatorOov1.EntryExit;
import BasicCalculatorOov2.Operation;

public class Calculator {
    static Operation oper = new Operation();

    public static void main(String[] args) {
        while (true) {
            int number1 = EntryExit.infonum1();
            int number2 = EntryExit.infonum2();
            int action = EntryExit.infop();

            String msg = oper.calculate(number1, number2, action);
            EntryExit.showResult(msg);
        }
    }
}