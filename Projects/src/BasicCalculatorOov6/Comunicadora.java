package BasicCalculatorOov6;

import BasicCalculatorOov1.EntryExit;

public class Comunicadora {
    public void executar() {
        while (true) {

            int numero1 = EntryExit.infonum1();
            int numero2 = EntryExit.infonum2();
            int acao = EntryExit.infop();

            Controladora controle = new Controladora();

            String msg = controle.calcular(numero1, numero2, acao);

            EntryExit.showResult(msg);

        }
    }
}