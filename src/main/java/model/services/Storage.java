package model.services;

import model.entities.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Storage {

    private List<Product> productList;

    public Storage() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addProduct(String name, double price, int quantity, int id) {
        productList.add(new Product(id, name, quantity, price));
    }

    public void deleteProduct(Integer id) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }

    public void updateProduct(Integer id, String name, Integer quantity, Double price) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
            }
        }
    }

    public void updateProduct(int id, int quantity) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                product.setQuantity(quantity);
            }
        }

    }

    public void accessProductList() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void accessProductList(String charactere) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().charAt(0) == charactere.charAt(0)) {
                System.out.println(product);
            }
        }
    }

    public void accessProductListByName(String name) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
            }
        }

    }

    public Product getProductById(int id) {
        for (Product x : productList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

}
