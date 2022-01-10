import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarRentalTester {
    public static void main(String[] args) {
        MenuDisplay menuDisplay;
        Customer customer;
        CarBooking carBooking;
        CarAndBookingDates carAndBookingDates = new CarAndBookingDates();

        //This is the file path to the csv file
        String filepath = "C:\\Users\\Brian Ronoh\\Downloads\\CarList.csv";

        String TEXT_RED = "\u001B[31m";  //Formats error messages to be displayed in red
        String TEXT_RESET = "\u001B[0m";  //Resets formart of output after error display

        menuDisplay = new MenuDisplay(); //Initializes the MenuDisplay object

        Boolean exit = false;  //Exit condition

        //Do not exit the program if the user has not selected the exit option.
        while (!exit){
            int carsAvailable = menuDisplay.displayCarList();
            if (carsAvailable == 0){
                break;
            }
            int choice = menuDisplay.getSelection();
            if (choice == 1){
                int carNumber = carAndBookingDates.carSelection(carsAvailable); //Get the available number of cars
                LocalDate startDate = carAndBookingDates.getCarBookingDateFull();  // Get start date
                LocalDate endDate = carAndBookingDates.getCarBookingEndDate();  //Get end date

//                If the difference between the startDate and the endDate is 0, handle error
                while (ChronoUnit.DAYS.between(startDate, endDate) <= 0){
                    System.out.println(TEXT_RED + "Invalid start and end booking dates! Enter start date and end date again: " + TEXT_RESET);
                    startDate = carAndBookingDates.getCarBookingDateFull();
                    endDate = carAndBookingDates.getCarBookingEndDate();
                }

                //Get the customer details and make booking
                customer = carAndBookingDates.getCustomerDetails();
                carBooking = new CarBooking(startDate, endDate, carNumber);
                carBooking.makeBooking();

                // print the booking details
                PrintBookingDetails printBookingDetails = new PrintBookingDetails();
                printBookingDetails.printBookingDetails(carBooking, customer);
            }
            else if (choice == 2){
                exit = true;
            }
            else
                System.out.println(TEXT_RED + "Invalid selection, please input a valid choice to continue:" + TEXT_RESET);
        }
    }
}
