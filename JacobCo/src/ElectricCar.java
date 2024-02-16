public class ElectricCar extends Car{

    private String bikeType;

    public ElectricCar(String make, String model, int year, double rentalRate, String bikeType) {
        super(make, model, year, rentalRate);
        this.bikeType = bikeType;
    }
    @Override
    public int getType() {
        return 3; // ElectricCar type
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bike Type" + bikeType);
    }

}
