package store;

/**
 *
 * @author IT676
 */
public class Product {

    private String id;
    private String name;
    private String supplier;
    private double price;

    public Product(String id, String name, String supplier, double price) {

        this.id = id;
        this.name = name;
        this.supplier = supplier;
        setPrice(price);
    }

    public void setPrice(double price) {

        /*
         validate the price 
         if price is less than zero (negative)
         then set it to zero
         */
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }

    }

    //we need this method to search for a product by id later
    public String getId() {

        return id;
    }

    @Override
    public String toString() {

        return String.format("- Product ID: %s%n"
                + "- Product Name: %s%n- Product Supplier: %s%n"
                + "- Product Price: %s%n",
                id, name, supplier, price);

    }
}
