package interfacegrafica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import objects.Coupon;
import objects.Product;
import objects.Stock;

public class OptionMenu {
    Stock stock = new Stock();
    List<Coupon> coupons = new ArrayList<Coupon>();

    public void showMenu() {
        while (true) {
            int action = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Produtos\n"
                    + "2 - Listar os Produtos\n" + "3 - Adicionar Produtos\n" + "4 - Vizualizar os cupons\n"
                    + "5 - Calcular o valor dos cupons\n" + "6 - Vender Produto\n" + "7 - Sair"));
            switch (action) {
            case 1:
                registerProducts();
                break;
            case 2:
                showProducts();
                break;
            case 3:
                addProducts();
                break;
            case 4:
                showCoupons();
                break;
            case 5:
                calculateCoupons();
                break;
            case 6:
                sellProducts();
                break;
            case 7:
                System.exit(1);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Você informou uma opção invalida");
                break;
            }
        }
    }

    private void sellProducts() {
        Product selectedProduct = this.requestProduct();
        if (selectedProduct != null) {
            if (selectedProduct.getQuantity() > 0) {
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Produto encontrado, existem "
                        + selectedProduct.getQuantity() + " no estoque, quantos quer vender ?"));
                if (quantity <= selectedProduct.getQuantity()) {
                    Coupon coupon = new Coupon();
                    coupon.setProduct(selectedProduct.getName());
                    coupon.setValor(selectedProduct.getPrice() * quantity);
                    coupon.setQuantity(quantity);
                    this.coupons.add(coupon);
                    selectedProduct.removeQuantity(quantity);
                    JOptionPane.showMessageDialog(null, "Produto vendido");
                } else {
                    JOptionPane.showMessageDialog(null, "Você digitou uma quantidade que não temos em estoque");
                }
            } else {
                JOptionPane.showMessageDialog(null, "o estoque desse produto está vazio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você digitou um produto ou código inexistente");
        }
    }

    private Product requestProduct() {
        Product selectedProduct = null;
        String idOrName = JOptionPane.showInputDialog("Informe o nome ou o código do produto");
        for (Product product : this.stock.getProducts()) {
            if (product.getId().equals(idOrName)) {
                selectedProduct = product;
            } else if (product.getName().equalsIgnoreCase(idOrName)) {
                selectedProduct = product;
            }
        }
        return selectedProduct;
    }

    private void addProducts() {
        Product product = this.requestProduct();
        if (product != null) {
            int quantity = Integer
                    .parseInt(JOptionPane.showInputDialog("Quantos produtos quer adicionar ao estoque ?"));
            int samePrice = Integer.parseInt(JOptionPane.showInputDialog("O preo atual do produto é "
                    + product.getPrice() + " deseja manter o mesmo preço ? 1 - sim e 2 - não"));
            if (samePrice == 2) {
                float price = Float.parseFloat(JOptionPane.showInputDialog("Qual o novo preço do produto"));
                product.setPrice(price);
            }
            product.addQuantity(quantity);
            JOptionPane.showMessageDialog(null, "Produto adicionado");
        } else {
            JOptionPane.showMessageDialog(null, "Você digitou um produto ou código inexistente");
        }
    }

    private void calculateCoupons() {
        if (this.coupons.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem cupons cadastrados");
        } else {
            float value = 0f;
            for (Coupon coupon : this.coupons) {
                value += coupon.getValor();
            }
            JOptionPane.showMessageDialog(null, "O valor total de cupons é: " + value);
        }
    }

    private void showCoupons() {
        if (this.coupons.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem cupons cadastrados");
        } else {
            String message = "";
            int count = 1;
            for (Coupon coupon : this.coupons) {
                message += "Cupom: " + count + "\n" + "Produto: " + coupon.getProduct() + " quantidade: "
                        + coupon.getQuantity() + " valor: " + coupon.getValor() + "\n";
                count++;
            }
            JOptionPane.showMessageDialog(null, message);
        }
    }

    private void showProducts() {
        String products = "";
        for (Product product : this.stock.getProducts()) {
            products += "Produto: " + product.getName() + "\n" + "ID: " + product.getId() + "\n" + "Preço: "
                    + product.getPrice() + "\n" + "Quantidade: " + product.getQuantity() + "\n" + "Descrição: "
                    + product.getDescription() + "\n";
        }

        JOptionPane.showMessageDialog(null, products);
    }

    private void registerProducts() {
        String productName = JOptionPane.showInputDialog("Qual o produto deseja cadastrar ?");
        String id = JOptionPane.showInputDialog("Qual o código do produto ?");
        String description = JOptionPane.showInputDialog("Informe a descrição do produto");
        float price = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do produto"));
        Product product = new Product();
        product.registerProduct(id, price, description, productName);
        this.stock.addProduct(product);
    }
}