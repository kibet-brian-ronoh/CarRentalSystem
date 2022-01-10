public class PremiumCar extends Car{
    double INSURANCERATE = 0.05;  //Constant represents a 5% increment in daily rates for premium cars
    public PremiumCar(double carRate, String carName) {
        super(carRate, carName);
    }

    /*The method below overrides the getCarRate method initially declared in
        the super class Car*/
    @Override
    public double getCarRate() {
        return carRate;
    }

}
