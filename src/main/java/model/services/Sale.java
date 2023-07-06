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

    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(int productId, int productQntt) {
        for (Product x : storage.getProductList()) {
            if (x.getId() == productId && x.getQuantity() >= productQntt) {
                Product productInCart = getProductFromCart(productId);
                if (productInCart != null) {
                    productInCart.setQuantityCart(productInCart.getQuantityCart() + productQntt);
                } else {
                    Product productToAdd = new Product(x);
                    productToAdd.setQuantityCart(productQntt);
                    cart.add(productToAdd);
                }
                x.subtractFromQuantity(productQntt);
                break;
            }
        }
    }
    public void deleteFromCart(int productId, int productQntt) {
        Product productInCart = getProductFromCart(productId);
        if (productInCart != null && productInCart.getQuantityCart() >= productQntt) {
            productInCart.setQuantityCart(productInCart.getQuantityCart() - productQntt);
            Product product = storage.getProductById(productId);
            product.addToQuantity(productQntt);
            if (productInCart.getQuantityCart() <= 0) {
                cart.remove(productInCart);
            }
        }
    }

    private Product getProductFromCart (int id) {
        for (Product x : cart) {
           if (x.getId() == id) {
               return x;
           }
        }
        return null;
    }
    public void accessCartList() {
        for (Product product : cart) {
            System.out.println(product.toStringCart());
        }
<<<<<<< HEAD
        System.out.println("Total Price: " + String.format("%.2f",getCartTotalPrice()));
    }
    public Double getCartTotalPrice() {
        Double totalPrice = 0.0;
        for (Product product : cart) {
            totalPrice += product.getTotalPrice();
        }
        return totalPrice;
    }


=======
    }



>>>>>>> 7409498e2502146f748595431861c03d44836161
}
