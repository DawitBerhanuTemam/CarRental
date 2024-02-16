public class Car {
    private String make;
    private String model;
    private int year;
    private double rentalRate;

    public Car(String make, String model, int year, double rentalRate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRate = rentalRate;
    }

    public int getType() {
        return 0;
    }

    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model " + model);
        System.out.println("Year: " + year);
        System.out.println("Rental Rate: " + rentalRate);
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
