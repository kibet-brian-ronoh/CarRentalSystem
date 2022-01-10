import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.Scanner;

public class CarAndBookingDates {
    int day;
    int month;
    int year;
    String TEXT_RED = "\u001B[31m"; //Displays text in red on error
    String TEXT_RESET = "\u001B[0m"; //Resets text display color after displaying in red

//    Constructor to initialize day, month and year with default values of the current time
//    and date
    public CarAndBookingDates() {
        LocalDate now = LocalDate.now();
        day = now.getDayOfMonth();
        month = now.getMonthValue();
        year = now.getYear();
    }

//    Prompts user to select a car from the list read from the csv file
    public int carSelection(int carsAvailable) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make a booking: ");
        System.out.println("Select car from the list above: ");
        int carChoice = scanner.nextInt();

//        Handling input of erroneous car i.e when user selects a car not on the list
        while (carChoice <= 0 || carChoice > carsAvailable) {
            System.out.println(TEXT_RED + "Invalid selection. Try again: " + TEXT_RESET);
            carChoice = scanner.nextInt();
        }
        return carChoice - 1; //To get the index of the chosen car, index starts at 0 and user enters as from 1
    }

 /*   This method calls the prompt methods to prompt the user for the start date of booking.
        It returns a LocalDate object. */
    public LocalDate getCarBookingDateFull(){
        System.out.println("Enter booking start date: ");
        //Call the prompt methods to get the date
        int y = promptForYear();
        int m = promptForMonth();
        int d = promptForDay();
        return LocalDate.of(y, m, d);
    }

    /*Similar to the getCarBookingDateFull method and returns date object representing the end Date
    entered by user.*/
    public LocalDate getCarBookingEndDate(){
        System.out.println("Enter booking end date: ");
        int y = promptForYear();
        int m = promptForMonth();
        int d = promptForDay();
        LocalDate localDate = LocalDate.of(y, m, d);
        return localDate;
    }

    /*Prompts user for theie details i.e. email, name, address. It returns a customer object*/
    public Customer getCustomerDetails (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your name: ");
        String name = scanner.nextLine();
        System.out.println("Your email: ");
        String email = scanner.nextLine();
        System.out.println("Your residential address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(name, email, address);
        return customer;
    }

    private int promptForYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the year - for example '2021': ");
        int year = scanner.nextInt();
        while (!validateYearString(year)) {
            System.out.println(TEXT_RED + "Invalid year entry! Try again: " + TEXT_RESET);
            year = scanner.nextInt();
        }
        this.year = year;
        return year;
    }

    private static boolean validateYearString(int year) {
        LocalDate todaysDate = LocalDate.now();
        int currentYear = todaysDate.getYear();
        int MAX_CAR_RENTAL_YEARS = 2; //This is an assumption that the company can rent out a car for a maximum of 2 years
        if (!((1970 < year) && (year < currentYear + MAX_CAR_RENTAL_YEARS))){
            return false;
        }
        return true;
    }

    private int promptForMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the month number - for example '2': ");
        int month = scanner.nextInt();
        while (!validateMonthString(month)) {
            System.out.println(TEXT_RED + "Invalid month entry! Try again: " + TEXT_RESET);
            month = scanner.nextInt();
        }
        this.month = month;
        return month;
    }

    private static boolean validateMonthString(int month) {
        //Months are valid from range 1 - 12
        if (month < 1 || month > 12){
            return false;
        }
        return true;
    }

//    Method prompts user for date entry
    private int promptForDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the date number - for example '2': ");
        int date = scanner.nextInt();
        while (!validateDayString(date)) {
            System.out.println(TEXT_RED + "Invalid date entry! Try again: " + TEXT_RESET);
            date = scanner.nextInt();
        }
        this.day = date;
        return date;
    }

//    Method to validate date
    private boolean validateDayString(int date) {
        // Get the number of days in that month
        YearMonth yearMonthObject = YearMonth.of(this.year, this.month);
        int daysInMonth = yearMonthObject.lengthOfMonth(); // Maximum days in the month entered
        //Check for validity of day according to month and year
        if (date < 1 || date > daysInMonth){
            return false;
        }
        return true;
    }

}
