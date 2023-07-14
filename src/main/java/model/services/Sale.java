package model.services;

import model.entities.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {
    private List<Product> cart;
    private Storage storage;
    private int saleId;
    private Date saleDate;

    public Sale(Storage storage) {
        this.storage = storage;
        this.cart = new ArrayList<>();
    }

    public List<Product> getCart() {
        return cart;
    }
    public List<Product> getCartProducts() {
        return new ArrayList<>(cart);
    }


    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public void finishSale(SaleHistory saleHistory) {
        // Cria uma nova venda com base na venda atual
        Sale sale = new Sale(this.storage);
        sale.setSaleId(this.saleId);
        sale.setSaleDate(this.saleDate);

        // Adiciona os produtos do carrinho à nova venda
        for (Product product : this.cart) {
            sale.addToCart(product.getId(), product.getQuantityCart());
        }

        // Subtrai a quantidade do produto no armazém e adiciona a venda ao histórico de vendas
        for (Product product : this.cart) {
            Product productInStorage = storage.getProductById(product.getId());
            if (productInStorage != null) {
                productInStorage.subtractFromQuantity(product.getQuantityCart());
            }
        }

        // Adiciona a venda ao histórico de vendas
        saleHistory.addSale(sale);

        // Limpa o carrinho atual
        this.cart.clear();
    }



    private Product getProductFromCart(int id) {
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
        System.out.println("Total Price: " + String.format("%.2f", getCartTotalPrice()));
    }


    public Double getCartTotalPrice() {
        Double totalPrice = 0.0;
        for (Product product : cart) {
            totalPrice += product.getTotalPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", saleDate=" + saleDate +
                '}';
    }
}
