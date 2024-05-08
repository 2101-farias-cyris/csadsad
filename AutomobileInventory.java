import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutomobileInventory {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public AutomobileInventory() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    // Parameterized Constructor
    public AutomobileInventory(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    public String addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added.";
        } catch (Exception e) {
            return "Something went wrong." + e.getMessage();
        }
    }

    public String[] listVehicleInformation() {
        try {
            String[] info = { make, model, color, String.valueOf(year), String.valueOf(mileage) };
            return info;
        } catch (Exception e) {
            return new String[] { " " + e.getMessage() };
        }
    }

    public String removeVehicle() {
        try {
            make = null;
            model = null;
            color = null;
            year = 0;
            mileage = 0;
            return "Vehicle removed.";
        } catch (Exception e) {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return " ";
        } catch (Exception e) {
            return "Erorr" + e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutomobileInventory car = new AutomobileInventory();

        try {

            car = new AutomobileInventory("Subaru", "Impreza", "Purple", 2020, 200000);

            // Call the method to list the values
            String[] vehicleInfo = car.listVehicleInformation();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            System.out.println(car.removeVehicle());

            System.out.println(car.addVehicle("Honda", "Civic", "Blue", 2000, 150000));

            vehicleInfo = car.listVehicleInformation();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            System.out.println(car.updateVehicleAttributes("BMW", "Expesive", "Black", 2019, 30000));

            vehicleInfo = car.listVehicleInformation();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            System.out.println("Do you want to print the information to a file? (Y/N)");
            String response = scanner.nextLine().toUpperCase();

            if (response.equals("Y")) {
                printToFile(vehicleInfo);
            } else if (response.equals("N")) {
                System.out.println("File will not be printed.");
            } else {
                System.out.println("Error");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void printToFile(String[] vehicleInfo) {
        try {
            FileWriter writer = new FileWriter("Autos.txt");
            for (String info : vehicleInfo) {
                writer.write(info + "\n");
            }
            writer.close();
            System.out.println("Printed into a file ");
        } catch (IOException e) {
            System.out.println("Falied try again" + e.getMessage());
        }
    }
}
