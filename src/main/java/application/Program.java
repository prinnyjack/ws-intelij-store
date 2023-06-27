package application;

import model.entities.Product;
import model.services.Sale;
import model.services.Storage;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);

        Storage storage = new Storage();
        Sale sale = new Sale(storage);

        Product product0 = new Product (123, "TV", 2, 2.500);
        storage.addProduct(product0);
        Product product1 = new Product (153, "COMPUTADOR", 1, 1.250);
        storage.addProduct(product1);
        Product product2 = new Product(168, "RELOGIO", 5, 1.000);
        storage.addProduct(product2);
        Product product3 = new Product(178, "REGATA", 10, 55.59);
        storage.addProduct(product3);

        storage.accessProductList();



        System.out.println("---------------DELETE-------------- ");
        storage.deleteProduct(153);
        storage.accessProductList();

        System.out.println("-------------UPDATE--------------");
        storage.updateProduct(123, "CARRO", 1, 52.000);
        storage.accessProductList();
        System.out.println("----------------LISTA POR NOME DE PRODUTO----------------");
        storage.accessProductListByName("regata");
        System.out.println("---------------------LISTA POR INICIAL---------------");
        storage.accessProductList("R");
        System.out.println("-------------------------CARRINHO------------------------");

        sale.addToCart(168, 6);
        storage.accessProductList();




        sc.close();
    }
}
