package store;

/**
 *
 * @author IT676
 */
public class Customer {

    private String name;
    private String address;
    private String phone;
    private String email;

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {

        return String.format("- name: %s%n- address: %s%n- email: %s%n"
                + "- phone number: %s%n", name, address, email, phone);
    }

}
