package BasicCalculatorOov2;

import BasicCalculatorOov1.EntryExit;

public class Calculator {

    public static void main(String[] args) {

        while (true) {
            int number1 = EntryExit.infonum1();
            int number2 = EntryExit.infonum2();
            int action = EntryExit.infop();

            Operation oper = new Operation();
            String msg = oper.calculate(number1, number2, action);
            EntryExit.showResult(msg);
        }

    }

}