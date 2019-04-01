package app.ListTwo;

import javax.swing.JOptionPane;

public class FastFood {
	// Implementado os if para verificar se é necessario pedir quantidade e o while
	public FastFood() {
		Order order = new Order();
		System.out.println("Lanches: ");
		System.out.println("1 - X-Bacon: R$15,00");
		System.out.println("2 - X-Salada: R$5,00");
		System.out.println("3 - X-Picanha: R$20,00");
		System.out.println("4 - X-Tudo: R$30,00");
		System.out.println("Bebidas: ");
		System.out.println("1 - Coca: R$4,00");
		System.out.println("2 - Agua: R$2,00");

		order.food = Integer.parseInt(JOptionPane.showInputDialog("Qual lanche você quer ? "));
		if (order.food > 0) {
			order.foodQuantity = Integer.parseInt(JOptionPane.showInputDialog("Quantos lanche você quer ? "));
		}
		order.drink = Integer.parseInt(JOptionPane.showInputDialog("Qual bebida você quer ? "));
		if (order.drink > 0) {
			order.drinkQuantity = Integer.parseInt(JOptionPane.showInputDialog("Quantas bebidas você quer ? "));
		}

		while (order.food <= 0 && order.drink <= 0) {
			JOptionPane.showMessageDialog(null, "Você precisa escolher 1 lanche ou 1 bebida");
			order.food = Integer.parseInt(JOptionPane.showInputDialog("Qual lanche você quer ? "));
			if (order.food > 0) {
				order.foodQuantity = Integer.parseInt(JOptionPane.showInputDialog("Quantos lanche você quer ? "));
			}
			order.drink = Integer.parseInt(JOptionPane.showInputDialog("Qual bebida você quer ? "));
			if (order.drink > 0) {
				order.drinkQuantity = Integer.parseInt(JOptionPane.showInputDialog("Quantas bebidas você quer ? "));
			}
		}

		switch (order.food) {
		case 1:
			JOptionPane.showMessageDialog(null,
					"Você solocitou " + order.foodQuantity + " X-Bacon no valor de R$15,00 cada");
			order.value = 15 * order.foodQuantity;
			break;
		case 2:
			JOptionPane.showMessageDialog(null,
					"Você solocitou " + order.foodQuantity + " X-Salada no valor de R$5,00 cada");
			order.value = 5 * order.foodQuantity;
			break;
		case 3:
			JOptionPane.showMessageDialog(null,
					"Você solocitou " + order.foodQuantity + " X-Picanha no valor de R$20,00 cada");
			order.value = 20 * order.foodQuantity;
			break;
		case 4:
			JOptionPane.showMessageDialog(null,
					"Você solocitou " + order.foodQuantity + " X-Tudo no valor de R$30,00 cada");
			order.value = 30 * order.foodQuantity;
			break;

		default:
			JOptionPane.showMessageDialog(null, "Você informou uma opção invalida de lanche");
			break;
		}

		switch (order.drink) {
		case 1:
			JOptionPane.showMessageDialog(null,
					"Você solocitou " + order.drinkQuantity + " coca no valor de R$4,00 cada");
			order.value += 4 * order.drinkQuantity;
			break;
		case 2:
			JOptionPane.showMessageDialog(null,
					"Você solocitou " + order.drinkQuantity + " águas no valor de R$2,00 cada");
			order.value += 2 * order.drinkQuantity;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Você informou uma opção invalida de bebida");
			break;
		}

		JOptionPane.showMessageDialog(null, "O valor total da sua compra é R$" + order.value + ",00");
	}
}

class Order {
	int food;
	int foodQuantity;
	int drink;
	int drinkQuantity;
	int value;
}