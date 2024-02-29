public class ElectricCar extends Car{

    private String motortype;

    public ElectricCar(String make, String model, int year, double rentalRate, String motortype) {
        super(make, model, year, rentalRate);
        this.motortype = motortype;
    }
    @Override
    public int getType() {
        return 3; // ElectricCar type
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("motor type:" + motortype);
    }

}

