package application;

import model.exceptions.InsertProductException;
import model.services.Sale;
import model.services.SaleHistory;
import model.services.Storage;
import util.InputUtils;

import java.util.Scanner;

public class StoreManager {

    Storage storage = new Storage();
    Sale sale = new Sale(storage);
    SaleHistory saleHistory = new SaleHistory();

    private void showMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - ARMAZEM");
        System.out.println("2 - VENDA");
        System.out.println("3 - HISTORICO VENDAS (WORKING ON IT)");
        System.out.println("4 - FINALIZAR PROGRAMA");
    }

    private void showStorageMenu() {
        System.out.println("I - INSERIR PRODUTO");
        System.out.println("D -  DELETAR PRODUTO");
        System.out.println("U - ATUALIZAR PRODUTO");
        System.out.println("S - LISTA DE PRODUTOS");
        System.out.println("0 - MENU PRINCIPAL");
    }

    private void showSaleMenu() {
        System.out.println("1 - NOVA VENDA");
        System.out.println("0 - MENU PRINCIPAL");
    }

    //********************************************//
    private void insertProduct(Scanner sc) {
        System.out.println("**INSERINDO PRODUTO**");
        System.out.print("NOME: ");
        String name = sc.nextLine();
        System.out.print("PREÇO: ");
        double price = InputUtils.readDouble(sc);
        System.out.print("QUANTIDADE: ");
        int quantity = InputUtils.readInt(sc);
        System.out.print("ID: ");
        int id = InputUtils.readInt(sc);
        sc.nextLine();
        try {
            storage.addProduct(name, price, quantity, id);
            System.out.println("PRODUTO INSERIDO!");

        } catch (InsertProductException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private void deleteProduct(Scanner sc) {
        System.out.println("**DELETANDO PRODUTO**");
        System.out.print("ID: ");
        int id = InputUtils.readInt(sc);
        sc.nextLine();
        try {
            storage.deleteProduct(id);
            System.out.println("PRODUTO REMOVIDO!");
        } catch (InsertProductException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private void updateProduct(Scanner sc) {
        System.out.println("**ATUALIZANDO PRODUTO**");
        System.out.print("ID: ");
        int id = InputUtils.readInt(sc);
        sc.nextLine();
        System.out.print("NOVA QUANTIDADE: ");
        int quantity = InputUtils.readInt(sc);
        try {
            storage.updateProduct(id, quantity);
        } catch (InsertProductException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void sellProduct(Scanner sc) {
        System.out.println("**CARRINHO**");
        System.out.print("PRODUTO ID: ");
        int id = InputUtils.readInt(sc);
        System.out.print("QUANTIDADE: ");
        int quantity = InputUtils.readInt(sc);
        try {
            sale.addToCart(id, quantity);
            System.out.println("PRODUTO ADICIONADO AO CARRINHO");
            sale.accessCartList();

            System.out.print("Deseja adicionar mais produtos ao carrinho? (S/N): ");
            String option = sc.next().toUpperCase();
            if (option.equals("S")) {
                // Continue adicionando produtos ao carrinho
                sellProduct(sc);
            } else {
                // Conclua a venda
                sale.finishSale(saleHistory);
                System.out.println("Venda concluída!");
            }
        } catch (InsertProductException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }


    public void run() {
        Scanner sc = new Scanner(System.in);
        char option = ' ';
        showMenu();
        do {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Opção inválida. Tente novamente!");
            }
            option = Character.toLowerCase(input.charAt(0));
            switch (option) {
                case '1':
                    do {
                        showStorageMenu();
                        input = sc.nextLine();
                        if (input.isEmpty()) {
                            System.out.println("Opção inválida. Tente novamente!");
                        }
                        option = Character.toLowerCase(input.charAt(0));
                        switch (option) {
                            case 'i':
                                insertProduct(sc);
                                break;
                            case 'd':
                                deleteProduct(sc);
                                break;
                            case 'u':
                                updateProduct(sc);
                                break;
                            case 's':
                                storage.accessProductList();
                                break;
                            case '0':
                                showMenu();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente!");
                        }
                    }
                    while (option != '0');
                    break;
                case '2':
                    do {
                        showSaleMenu();
                        input = sc.nextLine();
                        if (!input.isEmpty()) {
                            option = Character.toLowerCase(input.charAt(0));
                        } else {
                            option = ' ';
                        }
                        switch (option) {
                            case '1':
                                sellProduct(sc);
                                if (sc.hasNextLine()) {
                                    sc.nextLine();
                                }
                                break;
                            case '0':
                                showMenu();
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente!");
                        }
                    }
                    while (option != '0');
                    break;
                case '3':
                    saleHistory.accessSaleHistory();
                    showMenu();
                    break;
                case '4':
                    System.out.println("Fim do programa!");
                    break;
            }
        }
        while (option != '4');
    }

}

