package store;

import java.util.ArrayList;

/**
 *
 * @author IT676
 */
public class Store {

    private String name;
    private ArrayList<Account> accounts;
    private ArrayList<Product> products;

    public Store(String name) {

        this.name = name;

        accounts = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {

        products.add(p);
    }

    public void deleteProduct(int index) {

        products.remove(index);

    }

    public void addAccount(Account account) {

        accounts.add(account);

    }

    public void displayProducts() {

        for (Product p : products) {

            System.out.print(p);
            System.out.println("**********************************************");

        }
    }

    public void displayAccounts() {

        for (Account account : accounts) {

            System.out.print(account);
            System.out.println("**********************************************");

        }
    }

    public Product getProductById(String id) {

        for (Product p : products) {

            if (p.getId().equals(id)) {
                return p;
            }
        }

        return null;

    }

    //use one of the following methods , both are correct
    /*
    
     public Account getAccount() {
    
     return accounts.get(0);
     }
     */
    public Account getAccountById(String id) {

        for (Account account : accounts) {

            if (account.getId().equals(id)) {
                return account;
            }
        }

        return null;

    }

    public String getName() {

        return this.name;
    }
}
