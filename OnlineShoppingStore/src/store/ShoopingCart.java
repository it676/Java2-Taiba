package store;

import java.util.ArrayList;

/**
 *
 * @author IT676
 */
public class ShoopingCart {

    private ArrayList<OrderedItem> items;

    public ShoopingCart() {

        items = new ArrayList<>();
    }

    public void addItem(OrderedItem item) {

        items.add(item);

    }

    public void displayCart() {

        for (OrderedItem item : items) {

            System.out.print(item.getProduct());
            System.out.println("**********************************************");
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("----------------------------------------------");

        }
    }

}
