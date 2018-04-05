package store;

/**
 *
 * @author IT676
 */
public class OrderedItem {

    private Product product;
    private int quantity;

    public OrderedItem(Product product, int quantity) {
        this.product = product;
        setQuantity(quantity);
    }

    public void setQuantity(int quantity) {

        if (quantity <= 0) {
            throw new RuntimeException("Invalid Quantity , Buy one at least !");
        }

        this.quantity = quantity;
    }

    public Product getProduct() {

        return product;
    }

    public int getQuantity() {

        return quantity;
    }
}
