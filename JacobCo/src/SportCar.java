public class SportCar extends Car{
    private int horsepower;

    private String cargoType;

    public SportCar(String make, String model, int year, double rentalRate, int horsepower, String cargoType) {
        super(make, model, year, rentalRate);
        this.horsepower = horsepower;
        this.cargoType = cargoType;
    }

    @Override
    public int getType() {
        return 1; // SportCar type
    }
    public int getHorsepower() {
        return horsepower;
    }
    // In the SportCar class
    public boolean hasHighHorsepower(int horsepowerThreshold) {
        return getHorsepower() > horsepowerThreshold;
    }

//    @Override
//    public static void displayInfo() {
//        super.displayInfo();
//        System.out.println("horsepower: " + horsepower);
//        System.out.println("Cargo type: " + cargoType);
//
//    }

    public static void displayCars() {
        Iterable<? extends SportCar> sportCars = null;
        for (SportCar sportCar : sportCars) {
            sportCar.displayInfo();  // Assuming you have a displayInfo method in the Car class
            System.out.println("Horsepower: " + sportCar.getHorsepower());
            System.out.println();
        }
    }

}
