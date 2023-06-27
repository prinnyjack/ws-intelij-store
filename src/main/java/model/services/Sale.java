package model.services;

import model.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Product> cart;
    private Storage storage;

    public Sale(Storage storage) {
        this.storage = storage;
        this.cart = new ArrayList<>();
    }

    public void addToCart (int productId, int productQntt) {
        for (Product x : storage.getProductList()) {
            if (x.getId() == productId && x.getQuantity() >= productQntt) {
                for (int i=1; i<productQntt; i++) {
                    cart.add(x);
                }
                x.subtractFromQuantity(productQntt);
                if (x.getQuantity() <=0) {
                    storage.deleteProduct(x.getId());
                }
                break;
            }
        }
    }

}
