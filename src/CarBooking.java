import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarBooking {
    LocalDate startDate;
    LocalDate endDate;
    int carNumber;  //Car Selected
    long totalDays;
    double newRate;
    double cost;
    Car car;

//    Constructor initializes startDate, endDate, carNumber
    public CarBooking(LocalDate startDate, LocalDate endDate, int carNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.carNumber = carNumber;
    }

    public void makeBooking (){

        //This is the file path to the csv file
        String filepath = "C:\\Users\\Brian Ronoh\\Downloads\\CarList.csv";

        String line = "";  //Line that buffered reader will write to
        int lineCounter = 0;
        String[] carSelectedInfo = new String[6]; //Array to store the car info contained in the csv line
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            while ((line = bufferedReader.readLine()) != null){
                if (lineCounter == this.carNumber){
                    carSelectedInfo = line.split(",");  //array is filled with elements delimited by a comma
                }
                ++lineCounter;
            }

            String carType = carSelectedInfo[4];
            this.newRate = Double.valueOf(carSelectedInfo[5]);
            this.car = new Car(this.newRate, carSelectedInfo[1]);
            calculateTotalDays();
            if (carType.equals("Standard")){
                this.newRate = Double.parseDouble(carSelectedInfo[5]);
                calculateCost(this.newRate, this.totalDays);
            }
            else if (carType.equals("Premium")){
                double oldRate = Double.parseDouble(carSelectedInfo[5]);
                this.newRate = oldRate + (0.05 * oldRate);
                calculateCost(this.newRate, this.totalDays);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calculateTotalDays (){
        this.totalDays = ChronoUnit.DAYS.between(startDate, endDate);
    }

    public void calculateCost (double newRate, long totalDays) {
        this.cost = newRate * totalDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public long getTotalDays() {
        return totalDays;
    }

    public double getNewRate() {
        return newRate;
    }

    public double getCost() {
        return cost;
    }

    public Car getCar() {
        return car;
    }
}
