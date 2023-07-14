package model.services;

import model.entities.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleHistory {
    private List<Sale> sales;

    public SaleHistory () {
        this.sales = new ArrayList<>();
    }

    public void addSale (Sale sale) {
        sale.setSaleId(sales.size() + 1);
        sale.setSaleDate(new Date());
        sales.add(sale);
    }
    public List<Sale> getSales () {
        return sales;
    }
    public void accessSaleHistory() {
        for (Sale x : sales) {
            System.out.println("Sale ID: " + x.getSaleId());
            List<Product> cartProducts = x.getCartProducts();
            for (Product product : cartProducts) {
                System.out.println(product.toStringCart());
            }
            System.out.println("Total Price: " + String.format("%.2f", x.getCartTotalPrice()));
            System.out.println(x.getSaleDate());
            System.out.println("----------------------------------------");
        }
    }

}
