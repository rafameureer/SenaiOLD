import java.util.Random;

public class Number08 {

	public static void main(String[] args) {
		
		Random random = new Random();
		Number bigger = new Number();
		Number smaller = new Number();
		int[][] randomMatriz = new int[10][10];
		// corrigir o maior e menor - Feito
		for (int i = 0; i < randomMatriz.length; i++) {
			for (int j = 0; j < randomMatriz[i].length; j++) {
				randomMatriz[i][j] = random.nextInt(9);
				if (randomMatriz[i][j] <= smaller.number || (i == 0 && j == 0)) {
					smaller.number = randomMatriz[i][j];
					smaller.position = "coluna " + (i + 1) + " linha " + (j + 1);
				}
				if (randomMatriz[i][j] >= bigger.number || (i == 0 && j == 0)) {
					bigger.number = randomMatriz[i][j];
					bigger.position = "coluna " + (i + 1) + " linha " + (j + 1);
				}
				System.out.print(randomMatriz[i][j] + " | ");
			}
			System.out.println();
			System.out.println("---------------------------------------");
		} // todas as posições - Feito
		System.out.println("O maior valor é " + bigger.number + " e está na linha " + bigger.position);
		System.out.println("O menor valor é " + smaller.number + " e fica nas posições " + smaller.position);
	}
}

class Number {
	String position;
	int number;
}
