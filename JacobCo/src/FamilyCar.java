public class FamilyCar extends Car{

    private int numDoors;
    private boolean isConvertible;
    private String fuelType;

    public FamilyCar(String make, String model, int year, double rentalRate, int numDoors, boolean isConvertible, String fuelType) {
        super(make, model, year, rentalRate);
        this.numDoors = numDoors;
        this.isConvertible = isConvertible;
        this.fuelType = fuelType;
    }

    @Override
    public int getType() {
        return 2; // FamilyCar type
    }
    //@Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Convertible: " + isConvertible);
        System.out.println("Fuel Type: " + fuelType);
    }
}