public class PrintBookingDetails {

    /*Print the booking details (Like a receipt)*/
    public void printBookingDetails(CarBooking carBooking, Customer customer) {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("Thanks for your booking %s", customer.customerName);
        System.out.println();
        System.out.printf("%-15s", "Email:");
        System.out.println(customer.customerEmail);
        System.out.printf("%-40s", "Address:");
        System.out.println(customer.customerAddress);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Booking Confirmed.");
        System.out.println("Here's your booking summary:");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-28s","Car Selected");
        System.out.println(carBooking.getCar().carName);
        System.out.printf("%-28s","Start date");
        System.out.println(carBooking.getStartDate());
        System.out.printf("%-28s","End date");
        System.out.println(carBooking.getEndDate());
        System.out.printf("%-28s","Number of days booked");
        System.out.println(carBooking.getTotalDays());
        System.out.printf("%-28s","Car Rate per day");
        System.out.println("$" + carBooking.getNewRate());
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-28s", "Total cost");
        System.out.println("$" + carBooking.getCost());
    }
}
