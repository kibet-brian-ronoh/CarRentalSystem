import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuDisplay {
    static String TEXT_RED = "\u001B[31m";
    static String TEXT_RESET = "\u001B[0m";
    static int displayCarList(){
        int noOfCars = 0;

        //This is the file path to the csv file
        String filepath = "C:\\Users\\Brian Ronoh\\Downloads\\CarList.csv";

        //Banner Message
        System.out.println("******************************************************************************************************");
        System.out.println("                               Welcome to Umoja Car Rental                                       ");
        System.out.println("******************************************************************************************************");
        System.out.println("Cars available for Booking: ");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Car No.           Car Name          Seats             Transmission      Car Type          Rate/Day($)       ");
        System.out.println("-------           --------          -----             ------------      --------          ----------- ");

        String line = "";  //Line that buffered reader will write to

        //Try to read from the csv file and handle exceptions
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));

            //Continously read the csv file line by line
            while ((line = bufferedReader.readLine()) != null){
                String[] carInfo;  //String array to store the line read
                carInfo = line.split(",");  //array is filled with elements delimited by a comma
                //Iterate through the array to print the line
                for (String i:
                     carInfo) {
                    String formattedString = String.format ("%-18s", i); // ASCII Formatting of strings, max chars = 18
                    System.out.print(formattedString);
                }
                System.out.println();
                ++noOfCars;  // Increment the available number of cars after reading a line containing info about 1 car
            }
        } catch (FileNotFoundException e) {
            System.out.println(TEXT_RED + "The system cannot find the file specified (CarList.csv)! Please check the file first." +TEXT_RESET);
            //e.printStackTrace();  //This is for debugging purposes
            return 0;
        } catch (IOException e) {
            System.out.println(TEXT_RED + "IOException: An I/O exception of some sort has occurred!" + TEXT_RESET);
            //e.printStackTrace();  //This is for debugging purposes
            return 0;
        }
        System.out.printf("Total %d cars available", noOfCars);
        System.out.println();
        System.out.println("**Please note for premium cars, an additional 5% is applied to the car rate");
        System.out.println();
    return noOfCars;
    }

    /*Method to get user choice on whether to exit the system or continue to make a booking*/
    static int getSelection(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select from one of the following options to proceed: ");
        System.out.println("1. To make a booking");
        System.out.println("2. To exit the system");
        System.out.println("Enter your selection: ");
        int choice = scanner.nextInt();
        return choice;
    }

}
