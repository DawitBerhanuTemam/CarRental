
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RentalSystemApp {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        RentalSystem rentalSystem = new RentalSystem();


        List<Car> sportCars = new ArrayList<>();
        sportCars.add(new SportCar("BMW", "BMW1", 2020, 100, 1, true, "cargo"));
        sportCars.add(new SportCar("Audi", "R8", 2019, 120, 1, false, "cargo"));
        sportCars.add(new SportCar("dVe", "R8", 2019, 500, 1, false, "cargo"));
        // Add more SportCar instances as needed

        List<Car> familyCars = new ArrayList<>();
        familyCars.add(new FamilyCar("Toyota", "CXR", 2000, 50, 50, true, "fuel"));
        familyCars.add(new FamilyCar("Honda", "CR-V", 2018, 40, 4, false, "fuel"));
        // Add more FamilyCar instances as needed

        List<Car> electricCars = new ArrayList<>();
        electricCars.add(new ElectricCar("Tesla", "F150", 2001, 200, "Dc Series motor"));
        electricCars.add(new ElectricCar("Nissan", "Leaf", 2010, 150, "Ac Series motor"));
        // Add more ElectricCar instances as needed

        // Add all vehicles to the rental system
        rentalSystem.addVehicles(sportCars);
        rentalSystem.addVehicles(familyCars);
        rentalSystem.addVehicles(electricCars);
        while (true) {

            System.out.println();
            System.out.println("===== Vehicle Rental System =====");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. Display Rental Information");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1: {
                    // Rent a vehicle
                    System.out.println("===== Rent a Vehicle =====");

                    // Display available car types
                    System.out.println("Available car types:");
                    System.out.println("1. Sport Car");
                    System.out.println("2. Family Car");
                    System.out.println("3. Electric Car");

                    // Get user choice for car type
                    System.out.print("Enter the car type (1, 2, or 3): ");
                    int carTypeChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    // Get user budget
                    System.out.print("Enter your budget: ");
                    double budget = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character

                    // Display available cars within budget for the chosen type
                    List<? extends Car> availableCars = rentalSystem.getAvailableVehicles();
                    System.out.println("Available cars within your budget:");

                    for (Car car : availableCars) {
                        if (car.getType() == carTypeChoice && car.getRentalRate() <= budget) {
                            car.displayInfo();  // Assuming you have a displayInfo method in your Car class
                            System.out.println();
                        }
                    }

                    // Prompt the user to choose a specific car to rent
                    System.out.print("Enter the make of the car you want to rent: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter the model of the car you want to rent: ");
                    String model = scanner.nextLine();

                    Car selectedVehicle = null;

                    // Check the available vehicles for the chosen make and model
                    for (Car v : rentalSystem.getAvailableVehicles()) {
                        if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                            selectedVehicle = v;
                            break;
                        }
                    }

                    if (selectedVehicle != null && selectedVehicle.getRentalRate() <= budget) {
                        // Add the vehicle to rented vehicles
                        rentalSystem.rentVehicle(selectedVehicle);
                        System.out.print("Enter the rental duration in days: ");
                        int rentalDuration = scanner.nextInt();
                        // Calculate total rental cost
                        double rc = rentalSystem.calculateRentalCost(selectedVehicle, rentalDuration);
                        System.out.println("Successfully rented.");
                        System.out.println("Total rental Cost: " + rc);
                    } else {
                        System.out.println("Matching vehicle is not available for rent within your budget.");
                    }

                    break;
                }
                case 2: {
                    //Return a vehicle
                    System.out.println("Enter the vehicle make: ");
                    String make = scanner.nextLine();
                    System.out.println("Enter the vehicle model: ");
                    String model = scanner.nextLine();

                    Car selectedVehicle = null;

                    //Checks the vehicles in rented vehicles
                    for(Car v : rentalSystem.getRentedVehicles()) {
                        if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                            selectedVehicle = v;
                        }
                    }
                    if(selectedVehicle != null) {
                        //Add to the returned vehicles
                        rentalSystem.returnVehicle(selectedVehicle);
                        System.out.println("Vehicle returned successfully.");
                    }
                    else {
                        System.out.println("Invalid return. Vehicle not rented.");
                    }
                }
                case 3: {
                    //Display Rental Information
                    rentalSystem.displayRentalInfo();
                    break;
                }


                case 4: {
                    //Exit
                    System.out.println("Thank you for using the Vehicle Rental System. Goodbye!");
                    scanner.close();
                    System.exit(0);

            }
                default:
                    System.out.println("Invalid choice. Please enter valid option...");

            }

        }



    }
}


