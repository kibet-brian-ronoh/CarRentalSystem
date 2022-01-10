import java.util.Scanner;

public class Customer {
    String customerName;
    String customerEmail;
    String customerAddress;

    //Constructor to initialize the above variables
    public Customer(String customerName, String customerEmail, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

//    The methods below are access methods to the above variables

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

}
