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

    public void addProduct(Product product) {
        productList.add(product);
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
    public void accessProductList() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }
    public void accessProductList(String charactere) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
           if(product.getName().charAt(0) == charactere.charAt(0)) {
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

}
