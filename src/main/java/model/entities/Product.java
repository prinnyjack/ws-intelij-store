package model.entities;

import java.util.Objects;

public class Product {

    private Integer id;
    private String name;
    private Integer quantity;
    private Double price;
    private Integer quantityCart;


    public Product(Integer id, String name, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.quantityCart = 0;
    }

    public Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.quantity = other.quantity;
        this.price = other.price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(Integer quantityCart) {
        this.quantityCart = quantityCart;
    }


    public void subtractFromQuantity(int productQntt) {
        if (this.quantity >= productQntt) {
            this.quantity -= productQntt;
        }
    }

    public void addToQuantity(int productQntt) {
        this.quantity += productQntt;
    }

    public Double getTotalPrice() {
        return price * quantityCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, price);
    }

    @Override
    public String toString() {
        return "Product= " +
                "id: " + id +
                ", name: " + name +
                ", quantity: " + quantity +
                ", price: " + String.format("%.3f", price);
    }

    public String toStringCart() {
        return "Product= " +
                "id: " + id +
                ", name: " + name +
                ", quantity: " + quantityCart +
                ", price: " + String.format("%.2f", getTotalPrice());
    }

}
