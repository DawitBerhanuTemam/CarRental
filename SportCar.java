public class SportCar extends Car{
    private int loadCapacity;
    private boolean isFourWheelDrive;
    private String cargoType;

    public SportCar(String make, String model, int year, double rentalRate, int loadCapacity, boolean isFourWheelDrive, String cargoType) {
        super(make, model, year, rentalRate);
        this.loadCapacity = loadCapacity;
        this.isFourWheelDrive = isFourWheelDrive;
        this.cargoType = cargoType;
    }

    @Override
    public int getType() {
        return 1; // SportCar type
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
        System.out.println("Four wheel drive: " + isFourWheelDrive);
        System.out.println("Cargo type: " + cargoType);

    }


}

