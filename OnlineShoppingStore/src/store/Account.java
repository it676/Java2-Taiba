package store;

/**
 *
 * @author IT676
 */
public class Account {

    private String id;
    private String userName;
    private String passWord;
    private Customer customer;
    private ShoopingCart cart;

    public Account(String id, String userName, String passWord, Customer customer) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.customer = customer;
        this.cart = new ShoopingCart();
    }

    //we need this method to search for an account by id later
    public String getId() {

        return id;
    }

    //return the shopping cart of the logged user
    public ShoopingCart cart() {

        return cart;
    }

    @Override
    public String toString() {

        return String.format("Account ID: %s%n"
                + "Account username: %s%n"
                + "Password: %s%n"
                + "Customer details for this account:%n%s", id, userName, passWord, customer.toString());

    }
}
