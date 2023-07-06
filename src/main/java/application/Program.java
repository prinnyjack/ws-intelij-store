package application;

import model.entities.Product;
import model.services.Sale;
import model.services.Storage;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        Storage storage = new Storage();
        Sale sale = new Sale(storage);

        Product product0 = new Product (123, "TV", 3, 2500.0);
        storage.addProduct(product0);
        Product product1 = new Product (153, "COMPUTADOR", 1, 4250.0);
        storage.addProduct(product1);
        Product product2 = new Product(168, "RELOGIO", 5, 1000.0);
        storage.addProduct(product2);
        Product product3 = new Product(178, "REGATA", 10, 55.0);
        storage.addProduct(product3);

        System.out.println("---------------------------ARMAZEM------------------");
        storage.accessProductList();

        System.out.println("-------------------------------CART----------------------");
        sale.addToCart(168, 3);
<<<<<<< HEAD
        sale.addToCart(123, 2);
        sale.accessCartList();

        System.out.println("--------------------CARRINHO COM MENOS PRODUTOS-----------------");
//        sale.deleteFromCart(168, 1);
//        sale.deleteFromCart(123, 1);
        sale.deleteFromCart(168, 3);
        sale.deleteFromCart(123, 2);
        sale.accessCartList();

        System.out.println("--------------------------ARMAZEM-------------------------------");
        storage.accessProductList();

=======
        sale.addToCart(123, 1);
        sale.accessCartList();

        System.out.println("--------------------CARRINHO COM MENOS PRODUTOS-----------------");
        sale.deleteFromCart(168, 1);
        sale.deleteFromCart(123, 1);
        sale.accessCartList();

        System.out.println("--------------------------ARMAZEM-------------------------------");
        storage.accessProductList();
>>>>>>> 7409498e2502146f748595431861c03d44836161

        sc.close();
    }
}
