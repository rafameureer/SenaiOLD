package BasicCalculatorOov5;

import BasicCalculatorOov1.EntryExit;

public class Comunicadora {
    public void execute() {
        while (true) {

            int number1 = EntryExit.infonum1();
            int number2 = EntryExit.infonum2();
            int acao = EntryExit.infop();

            Controladora control = new Controladora();

            String msg = control.calculate(number1, number2, acao);

            EntryExit.showResult(msg);

        }
    }
}