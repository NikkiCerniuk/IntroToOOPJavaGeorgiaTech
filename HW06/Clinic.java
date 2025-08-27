import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Clinic {

    // This is a class representing the vet clinic.

    // Variables: File patientFile- File with patient information, int day
    private File patientFile; // file to store patient information
    private int day;

    // Constructor 1
    public Clinic(File file) { // File that contains patient info - assign to patientFile
        this.patientFile = file;
        this.day = 1;
    } // end of constructor 1

    public Clinic(String fileName) {
        this(new File(fileName)); // this without the dot signifies constructor chaining in Java
    } // end of constructor 2

    // Overloaded method 1. pt 1 overload
    public String nextDay(File f) throws FileNotFoundException { // String nextDay(File f) throws FileNotFoundException
        StringBuilder result = new StringBuilder();
        Scanner fileScanner = new Scanner(f); // create a scanner to read the file 

        // Reads File f that contains the name, type of pet, and time of the appointments for the day
        String[] appointmentDetails = null;
        String time = ""; // Declare 'time' here to be used in the method
        while (fileScanner.hasNextLine()) { // while there is another line
            String line = fileScanner.nextLine(); // read next line from file
            appointmentDetails = line.split(","); // splits things by the comma-separated values

            if (appointmentDetails.length != 4) {
                System.out.println("Skipping invalid line: " + line);
                continue; // skips invalid lines and doesn't read those
            }

            String name = appointmentDetails[0].trim();
            String typeOfPet = appointmentDetails[1].trim();
            String miceOrDrool = appointmentDetails[2].trim();
            time = appointmentDetails[3].trim(); // Assign 'time' here
            Scanner scanner = new Scanner(System.in); // Use a Scanner object to take in user input
            System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n", name, typeOfPet, time, name); // Print the time here

            // Getting a valid number for health
            double health = Double.NaN; // nan stands for not a number, so while we need a number here, this will work
            while (Double.isNaN(health)) { // means while health is not a number.
                if (scanner.hasNextInt()) {
                    health = (double) scanner.nextInt(); // cast the int to a double

                } else if (scanner.hasNextDouble()) {
                    health = scanner.nextDouble();
                } else {
                    System.out.println("Please enter a number");
                    scanner.next(); // consume the invalid input
                }
            } // end of while loop for valid health number

            int painLevel = -1;
            while (painLevel == -1) { // take user input for pain level 
            System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name); // print prompt for pain level 
                if (scanner.hasNextInt()) {
                    painLevel = scanner.nextInt();

                } else if (scanner.hasNextDouble()) {
                    painLevel = (int) scanner.nextDouble(); // cast double to an int
                } else {
                    System.out.println("Please enter a number");
                    scanner.next(); // consume the invalid input 
                }
            }

            // checks if the pet is a dog or cat. if not, exception is thrown
            Pet pet;
            if (typeOfPet.equals("Dog")) {
                double droolRate = Double.parseDouble(miceOrDrool); // Assuming it's a drool rate for dog
                pet = new Dog(name, health, painLevel, droolRate);
            } else if (typeOfPet.equals("Cat")) {
                int miceCaught = Integer.parseInt(miceOrDrool); // Assuming it's mice caught for cat
                pet = new Cat(name, health, painLevel, miceCaught);
            } else {
                throw new InvalidPetException(); // If typeOfPet is not valid (i.e. not a Dog or Cat, case-sensitive) throw InvalidPetException
            }

            // Call speak()
            pet.speak();
            // treat pet 
            int treatmentTime = pet.treat();
            // Calculate time out (there exists a method for this)
            String timeOut = addTime(time, treatmentTime); // Use 'time' here
            result.append(String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d\n", name, typeOfPet, miceOrDrool, day, time, addTime(time, treatmentTime), health, painLevel));
        } // end of while loop

        fileScanner.close(); // Close the file scanner to release resources
        day++;
        return result.toString(); // return accumulated result as a string
    } // end of String nextDay(File f) throws FileNotFoundException pt 1 overload

    // Overloaded method 2. pt 2 overload
    public String nextDay(String fileName) throws FileNotFoundException {
        File f = new File(fileName); // makes the file name input into a file
        return nextDay(f); // passes it to the other overloaded method 
    } // end of public String nextDay(String fileName) throws FileNotFoundException

    // This method should calculate the time the patient’s appointment ends
    private String addTime(String timeIn, int treatmentTime) {
        int hour = Integer.parseInt(timeIn.substring(0, 2)); // converts from string to int
        int minute = Integer.parseInt(timeIn.substring(2, 4)); // converts from string to int

        minute += treatmentTime;
        if (minute >= 60) {
            hour += minute / 60;  // Increment hour if minutes exceed 60
            minute = minute % 60;
        }
        // If hour exceeds 24, reset to the next day (for safety)
        if (hour >= 24) {
            hour = hour % 24;
        }

        String timeOut = String.format("%02d%02d", hour, minute);
        return timeOut; // return timeOut. should be in military time and you can assume that it does not go across several days
    } // end of addTime

    public boolean addToFile(String patientInfo) {
        boolean petExists = false;
        try {
            Scanner scanner = new Scanner(patientFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String petName = parts[0]; // Extract pet name from the file

                // Check if the pet name already exists in the file
                if (petName.equals(patientInfo.split(",")[0])) {
                    petExists = true;
                    break; // If pet exists, exit the loop
                }
            }
            scanner.close();

            // If the pet doesn't exist, write the new appointment info to the file
            if (!petExists) {
                PrintWriter writer = new PrintWriter(new FileOutputStream(patientFile, true));
                writer.println(patientInfo); // Add new appointment details for the pet
                writer.close();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while adding to the file.");
            return false;
        }
        return true;
    }

    // method that throws an exception 
} // end of Clinic class 
