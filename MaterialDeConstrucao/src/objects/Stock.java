package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Stock
 */
public class Stock {

    private List<Product> products = new ArrayList<Product>();

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product produto) {
        this.products.add(produto);
    }

    public void removeProduct(Product produto) {
        this.products.remove(produto);
    }
}