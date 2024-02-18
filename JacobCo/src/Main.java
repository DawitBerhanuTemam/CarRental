// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        RentalSystem rentalSystem = new RentalSystem();

//        Car SportCar = new Car("BMW", "BMW1", 2020, 100);
//        Car FamilyCar = new Car("Toyota", "CXR", 2000, 50);
//        Car ElectricCar = new Car("Tesla", "F150", 2001, 200);

        Car sportCar = new SportCar("BMW", "BMW1", 2020, 100, 1000, "cargo");
        Car sportCar1 = new SportCar("Porsche", "Porsche1", 2022, 100, 700, "cargo");
        Car sportCar2 = new SportCar("McLaren", "McLaren720S", 2019, 100, 220, "cargo");
        Car familyCar = new FamilyCar("Toyota", "CXR", 2000, 50, 50, true, "fuel");
        Car electricCar = new ElectricCar("Tesla", "F150", 2001, 200, "specificElectricCarAttribute");

        rentalSystem.addVehicle(sportCar);
        rentalSystem.addVehicle(sportCar1);
        rentalSystem.addVehicle(sportCar2);
        rentalSystem.addVehicle(familyCar);
        rentalSystem.addVehicle(electricCar);


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

//            switch (choice) {
//                case 1: {
//                    //Rent a vehicle
//                    System.out.print("Enter the vehicle make: ");
//                    String make = scanner.nextLine();
//                    System.out.print("Enter the vehicle model: ");
//                    String model = scanner.nextLine();
//
//                    Car selectedVehicle = null;
//
//                    //1111Checks the vehicles in available vehicles
//                    for(Car v : rentalSystem.getAvailableVehicles()) {
//                        if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
//                            selectedVehicle = v;
//                        }
//
//                    }
//
//
//                    if(selectedVehicle != null) {
//                        //Add the vehicle to rented vehicles
//                        rentalSystem.rentVehicle(selectedVehicle);
//                        System.out.print("Enter the rental duration in days: ");
//                        int rentalDuration = scanner.nextInt();
//                        //Calculate total rental cost
//                        double rc = rentalSystem.calculateRentalCost(selectedVehicle, rentalDuration);
//                        System.out.println("Successfully rented.");
//                        System.out.println("Total rental Cost: " + rc);
//                    }
//                    else {
//                        System.out.println("Matching vehicle is not available for rent.");
//                    }
//                    break;
//
//                }
//
//                case 2: {
//                    //Return a vehicle
//                    System.out.println("Enter the vehicle make: ");
//                    String make = scanner.nextLine();
//                    System.out.println("Enter the vehicle model: ");
//                    String model = scanner.nextLine();
//
//                    Car selectedVehicle = null;
//
//                    //Checks the vehicles in rented vehicles
//                    for(Car v : rentalSystem.getRentedVehicles()) {
//                        if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
//                            selectedVehicle = v;
//                        }
//                    }
//                    if(selectedVehicle != null) {
//                        //Add to the returned vehicles
//                        rentalSystem.returnVehicle(selectedVehicle);
//                        System.out.println("Vehicle returned successfully.");
//                    }
//                    else {
//                        System.out.println("Invalid return. Vehicle not rented.");
//                    }
//                }
//
//                case 3: {
//                    //Display Rental Information
//                    rentalSystem.displayRentalInfo();
//                    break;
//                }
//
//                case 4: {
//                    //Exit
//                    System.out.println("Thank you for using the Vehicle Rental System. Goodbye!");
//                    scanner.close();
//                    System.exit(0);
//                }
//
//                default:
//                    System.out.println("Invalid choice. Please enter valid option...");
//
//            }
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

                    int carTypeDetailsChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    switch (carTypeDetailsChoice) {
                        case 1: {


                            // Rent a Sport Car
                            System.out.println("===== Rent a Sport Car =====");

                            // Ask Sport Car-specific question
                            System.out.print("Are you looking for high horsepower and quick acceleration times? (yes/no): ");
                            String sportCarPreference = scanner.next();

                            double horsepowerThreshold = 300;  // Set the threshold value for high horsepower

                            // Provide a choice based on the user's response
                            if ("yes".equalsIgnoreCase(sportCarPreference)) {
                                System.out.println("Great! We will prioritize Sport Cars with high horsepower and quick acceleration for you.");

                                // Get user budget
                                System.out.print("Enter your budget: ");
                                double budget = scanner.nextDouble();
                                scanner.nextLine();  // Consume the newline character

                                // Display available Sport Cars based on budget and horsepower threshold
                                List<SportCar> availableSportCarsWithinBudget = rentalSystem.getAvailableSportCarsAboveHorsepower(budget, horsepowerThreshold);
                                System.out.println("Available Sport Cars within your budget and above " + horsepowerThreshold + " horsepower:");
                                SportCar.displayCars();

                                // Get user choice for Sport Car
                                System.out.print("Enter the make of the Sport Car you want to rent: ");
                                String make = scanner.nextLine();
                                System.out.print("Enter the model of the Sport Car you want to rent: ");
                                String model = scanner.nextLine();

                                SportCar selectedSportCar = rentalSystem.findSportCar(availableSportCarsWithinBudget, make, model);

                                if (selectedSportCar != null) {
                                    // Add the Sport Car to rented vehicles
                                    rentalSystem.rentVehicle(selectedSportCar);
                                    System.out.print("Enter the rental duration in days: ");
                                    int rentalDuration = scanner.nextInt();
                                    // Calculate total rental cost
                                    double rc = rentalSystem.calculateRentalCost(selectedSportCar, rentalDuration);
                                    System.out.println("Successfully rented.");
                                    System.out.println("Total rental Cost: " + rc);
                                } else {
                                    System.out.println("Matching Sport Car is not available for rent.");
                                }
                            } else if ("no".equalsIgnoreCase(sportCarPreference)) {
                                System.out.println("Understood! We will provide Sport Cars with low horsepower to meet your preference.");
                                // Get user budget
                                System.out.print("Enter your budget: ");
                                double budget = scanner.nextDouble();
                                scanner.nextLine();  // Consume the newline character

                                // Display available Sport Cars based on budget
                                List<SportCar> availableSportCarsWithinBudget = rentalSystem.getAvailableSportCars(budget);
                                System.out.println("Available Sport Cars within your budget:");
                                SportCar.displayCars();

                                // Get user choice for Sport Car
                                System.out.print("Enter the make of the Sport Car you want to rent: ");
                                String make = scanner.nextLine();
                                System.out.print("Enter the model of the Sport Car you want to rent: ");
                                String model = scanner.nextLine();

                                SportCar selectedSportCar = rentalSystem.findSportCar(availableSportCarsWithinBudget, make, model);

                                if (selectedSportCar != null) {
                                    // Add the Sport Car to rented vehicles
                                    rentalSystem.rentVehicle(selectedSportCar);
                                    System.out.print("Enter the rental duration in days: ");
                                    int rentalDuration = scanner.nextInt();
                                    // Calculate total rental cost
                                    double rc = rentalSystem.calculateRentalCost(selectedSportCar, rentalDuration);
                                    System.out.println("Successfully rented.");
                                    System.out.println("Total rental Cost: " + rc);
                                } else {
                                    System.out.println("Matching Sport Car is not available for rent.");
                                }
                            } else {
                                System.out.println("Invalid response. Assuming you prefer a balanced Sport Car.");
                            }


                        }
                        break;

                        case 2: {
                            // Display Family Car details
                            System.out.println("===== Family Car Details =====");
                            System.out.println("Family Cars are designed for comfortable transportation of passengers.");
                            System.out.println("They often have spacious interiors and may prioritize cargo space.");

                            // You can add more details specific to Family Cars here

                            break;
                        }
                        case 3: {
                            // Display Electric Car details
                            System.out.println("===== Electric Car Details =====");
                            System.out.println("Electric Cars are environmentally friendly and rely on electric power for propulsion.");
                            System.out.println("They may offer features such as fast charging and have specific electric attributes.");

                            // You can add more details specific to Electric Cars here

                            break;
                        }

                        default:
                            // Continue with the vehicle rental process
                    }
                }

                case 2: {
                    //Return a vehicle
                    System.out.println("Enter the vehicle make: ");
                    String make = scanner.nextLine();
                    System.out.println("Enter the vehicle model: ");
                    String model = scanner.nextLine();

                    Car selectedVehicle = null;

                    //Checks the vehicles in rented vehicles
                    for (Car v : rentalSystem.getRentedVehicles()) {
                        if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                            selectedVehicle = v;
                        }
                    }
                    if (selectedVehicle != null) {
                        //Add to the returned vehicles
                        rentalSystem.returnVehicle(selectedVehicle);
                        System.out.println("Vehicle returned successfully.");
                    } else {
                        System.out.println("Invalid return. Vehicle not rented.");
                    }
                    break;
                }

                case 3: {
                    //Display Rental Information
//                    rentalSystem.displayRentalInfo();
                    break;
                }

                case 4: {
                    //Exit
                    System.out.println("Thank you for using the Vehicle Rental System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                }

                default:
                    System.out.println("Invalid choice. Please enter valid option...");

            }

//                    // Get user budget
//                    System.out.print("Enter your budget: ");
//                    double budget = scanner.nextDouble();
//                    scanner.nextLine();  // Consume the newline character
//
//                    // Display available cars within budget for the chosen type
//                    List<? extends Car> availableCars = rentalSystem.getAvailableVehicles();
//                    System.out.println("Available cars within your budget:");
//
//                    for (Car car : availableCars) {
//                        if (car.getType() == carTypeChoice && car.getRentalRate() <= budget) {
//                            car.displayInfo();  // Assuming you have a displayInfo method in your Car class
//                            System.out.println();
//                        }
//                    }
//
//                    // Prompt the user to choose a specific car to rent
//                    System.out.print("Enter the make of the car you want to rent: ");
//                    String make = scanner.nextLine();
//                    System.out.print("Enter the model of the car you want to rent: ");
//                    String model = scanner.nextLine();
//
//                    Car selectedVehicle = null;
//
//                    // Check the available vehicles for the chosen make and model
//                    for (Car v : rentalSystem.getAvailableVehicles()) {
//                        if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
//                            selectedVehicle = v;
//                            break;
//                        }
//                    }
//
//                    if (selectedVehicle != null && selectedVehicle.getRentalRate() <= budget) {
//                        // Add the vehicle to rented vehicles
//                        rentalSystem.rentVehicle(selectedVehicle);
//                        System.out.print("Enter the rental duration in days: ");
//                        int rentalDuration = scanner.nextInt();
//                        // Calculate total rental cost
//                        double rc = rentalSystem.calculateRentalCost(selectedVehicle, rentalDuration);
//                        System.out.println("Successfully rented.");
//                        System.out.println("Total rental Cost: " + rc);
//                    } else {
//                        System.out.println("Matching vehicle is not available for rent within your budget.");
//                    }
//
//                    break;

        }


    }


}
