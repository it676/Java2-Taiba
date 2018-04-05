package store;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author IT676
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Craete a Store object
        Store store = new Store("Camera Online Store");
        // Read all products from the products file
        File productFile = new File("products.txt");
        try (Scanner input = new Scanner(productFile);) {
            input.useDelimiter(",");
            while (input.hasNext()) {

                //read the data and create a product object
                //then add it to the store
                String id = input.next();
                String name = input.next();
                String supplier = input.next();
                double price = Double.parseDouble(input.next());

                //create product object
                Product product = new Product(id, name, supplier, price);

                //add it to the store
                store.addProduct(product);

            }
        }

        // Read all accounts from the account file
        File customerFile = new File("accounts.txt");
        try (Scanner input = new Scanner(customerFile);) {
            input.useDelimiter(",");
            while (input.hasNext()) {

                //read the data from the file
                String id = input.next();
                String userName = input.next();
                String passWord = input.next();
                String customerName = input.next();
                String customerAddress = input.next();
                String customerPhone = input.next();
                String customerEmail = input.next();

                //create an account object from this data 
                Account account = new Account(id, userName, passWord,
                        new Customer(customerName, customerAddress,
                                customerPhone, customerEmail));

                //add the account to the list
                store.addAccount(account);

            }
        }

        System.out.println("^^^^^^ Welcome to our " + store.getName() + " ^^^^^");
        System.out.println("*****************************************");

        while (true) {
            System.out.println("Are you a customer or an admin?\n  (1) for user \n  (2) for admin\n  (3) to exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: // User mode
                    int ans;
                    do {
                        System.out.println("Choose the required operations from the list below:\n  (1) Display all products \n  (2) Add a product to the shopping cart by id \n  (3) Go back to main menu");
                        choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 1) {
                            System.out.println("The list of available products: \n");

                            //call the method to display all products
                            store.displayProducts();

                        } else if (choice == 2) {
                            /* add to shopping cart */

                            System.out.println("Enter the id of the product:");
                            String id = sc.nextLine();

                            System.out.println("Enter the product quantity:");
                            int quantity = sc.nextInt();
                            Product product = store.getProductById(id);

                            //add the product to the logged user cart
                            store.getAccountById("0001").cart().addItem(new OrderedItem(product, quantity));

                            /*display the shopping cart for the logged user*/
                            System.out.println("Your cart now has the following items: ");
                            store.getAccountById("0001").cart().displayCart();

                        } else if (choice == 3) {
                            break;
                        }
                        System.out.println("Another user operation? (0) for yes | (1) for No.");
                        ans = sc.nextInt();
                    } while (ans == 0);
                    break;
                case 2:// Admin mode
                    do {
                        System.out.println("Choose the required operations from the list below:\n  (1) Display all products \n  (2) Display all accounts\n  (3) Add a product  \n  (4) Delete a product \n  (5) Go back to main menu");
                        choice = sc.nextInt();
                        sc.nextLine();
                        if (choice == 1) {
                            System.out.println("The list of available products: \n");

                            //call the method to display all products
                            store.displayProducts();

                        } else if (choice == 2) {
                            System.out.println("The list of accounts: \n");
                            //call the method to display all accounts
                            store.displayAccounts();
                        } else if (choice == 3) {
                            // read product details from the admin and add it to the products array list within the store
                            System.out.println("Enter the product id: ");
                            String id = sc.nextLine();
                            System.out.println("Enter the product name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter the product supplier: ");
                            String supplier = sc.nextLine();
                            System.out.print("Enter the product price: ");
                            double price = sc.nextDouble();

                            //create the product object and add it to the store
                            store.addProduct(new Product(id, name, supplier, price));

                            System.out.println("Great! The product has been added!");

                        } else if (choice == 4) {

                            System.out.println("Enter the index of the product to be deleted:");
                            int index = sc.nextInt();

                            store.deleteProduct(index);

                        } else if (choice == 5) {
                            break;
                        }
                        System.out.println("Another admin operation? (0) for yes| (1) for No");
                        ans = sc.nextInt();
                    } while (ans == 0);
                    break;
                case 3:
                    System.out.println("Thanks for visiting our store!");
                    System.exit(0);
                default:
                    System.out.println("Incorrect Entry! Try agian!");
                    break;
            }

        }

    }

}
