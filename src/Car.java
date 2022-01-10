public class Car {
    double carRate;
    String carName;

//    Constructor to initilize variables
    public Car(double carRate, String carName) {
        this.carRate = carRate;
        this.carName = carName;
    }

//    Getter method/ access method for caRate
    public double getCarRate() {
        return carRate;
    }

//    Getter/access method for the carName
    public String getCarName() {
        return carName;
    }
}
