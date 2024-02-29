import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private List<SportCar> availableSportCar;
    private List<SportCar> rentedSportCar;

    private List<FamilyCar> availableFamilyCar;
    private List<FamilyCar> rentedFamilyCar;

    private List<ElectricCar> availableElectricCar;
    private List<ElectricCar> rentedElectricCar;
    // Constructor to initialize empty lists for each car type
    public RentalSystem() {
        availableSportCar = new ArrayList<>();
        rentedSportCar = new ArrayList<>();
        availableFamilyCar = new ArrayList<>();
        rentedFamilyCar = new ArrayList<>();
        availableElectricCar = new ArrayList<>();
        rentedElectricCar = new ArrayList<>();
    }
    public List<Car> getAvailableVehicles() {
        List<Car> availableVehicles = new ArrayList<>();
        availableVehicles.addAll(availableSportCar);
        availableVehicles.addAll(availableFamilyCar);
        availableVehicles.addAll(availableElectricCar);
        return availableVehicles;
    }
    public List<Car> getRentedVehicles() {
        List<Car> rentedVehicles = new ArrayList<>();
        rentedVehicles.addAll(rentedSportCar);
        rentedVehicles.addAll(rentedFamilyCar);
        rentedVehicles.addAll(rentedElectricCar);
        return rentedVehicles;
    }

    public void addVehicles(List<Car> vehicles) {
        for (Car vehicle : vehicles) {
            if (vehicle instanceof SportCar) {
                availableSportCar.add((SportCar) vehicle);
            } else if (vehicle instanceof FamilyCar) {
                availableFamilyCar.add((FamilyCar) vehicle);
            } else if (vehicle instanceof ElectricCar) {
                availableElectricCar.add((ElectricCar) vehicle);
            }
        }
    }
    public void rentVehicle(Car vehicle) {
        if (vehicle instanceof SportCar) {
            if (availableSportCar.contains(vehicle)) {
                availableSportCar.remove(vehicle);
                rentedSportCar.add((SportCar) vehicle);
            }
        } else if (vehicle instanceof FamilyCar) {
            if (availableFamilyCar.contains(vehicle)) {
                availableFamilyCar.remove(vehicle);
                rentedFamilyCar.add((FamilyCar) vehicle);
            }
        } else if (vehicle instanceof ElectricCar) {
            if (availableElectricCar.contains(vehicle)) {
                availableElectricCar.remove(vehicle);
                rentedElectricCar.add((ElectricCar) vehicle);
            }
        }
    }

    public void returnVehicle(Car vehicle) {
        if (vehicle instanceof SportCar) {
            if (rentedSportCar.contains(vehicle)) {
                rentedSportCar.remove(vehicle);
                availableSportCar.add((SportCar) vehicle);
            }
        } else if (vehicle instanceof FamilyCar) {
            if (rentedFamilyCar.contains(vehicle)) {
                rentedFamilyCar.remove(vehicle);
                availableFamilyCar.add((FamilyCar) vehicle);
            }
        } else if (vehicle instanceof ElectricCar) {
            if (rentedElectricCar.contains(vehicle)) {
                rentedElectricCar.remove(vehicle);
                availableElectricCar.add((ElectricCar) vehicle);
            }
        }
    }



    public void displayRentalInfo(List<? extends Car> available, List<? extends Car> rented) {
        System.out.println("Available vehicles: ");
        for (Car av : available) {
            av.displayInfo();
            System.out.println();
        }

        System.out.println("Rented vehicles: ");
        for (Car rv : rented) {
            rv.displayInfo();
            System.out.println();
        }
    }
    public void displayRentalInfo() {
        List<Car> availableVehicles = getAvailableVehicles();
        List<Car> rentedVehicles = getRentedVehicles();

        System.out.println("Available vehicles: ");
        for (Car av : availableVehicles) {
            av.displayInfo();
            System.out.println();
        }

        System.out.println("Rented vehicles: ");
        for (Car rv : rentedVehicles) {
            rv.displayInfo();
            System.out.println();
        }
    }
    public double calculateRentalCost(Car vehicle, int rentalDuration) {
        // Adjustments for FamilyCar and ElectricCar
        if (vehicle instanceof SportCar) {
            double rentalRate = ((SportCar) vehicle).getRentalRate();
            return rentalRate * rentalDuration;
        }
        return 0.0; // Handle other vehicle types accordingly
    }
}
