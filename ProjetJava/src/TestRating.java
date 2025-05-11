

import java.util.List;
import java.util.Scanner;
// The user chooses scores and comments via keyboard
public class TestRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RatingSystem system = new RatingSystem();

        // Two users for testing
        User passenger = new User("Dupont", "Jean", "U001", 0.0f, "Passenger");
        User driver = new User("Martin", "Sophie", "U002", 0.0f, "Driver");

        System.out.println("Welcome to the rating system (Member 3, USTHB Carpooling)");
        System.out.println("---------------------------------------");

        while (true) {
            // Prompt for the type of rating
            System.out.println("\nChoose an action:");
            System.out.println("1. Passenger rates driver");
            System.out.println("2. Driver rates passenger");
            System.out.println("3. Display ratings and reputation");
            System.out.println("4. Quit");
            System.out.print("Your choice (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number between 1 and 4, that's wrong!");
                continue;
            }

            if (choice == 4) {
                System.out.println("Thank you, program terminated!");
                break;
            }

            if (choice == 3) {
                // Display ratings and reputation
                System.out.println("\nRatings for driver (" + driver.getLastName() + "):");
                List<Rating> driverRatings = system.getRatingsForUser(driver);
                if (driverRatings.isEmpty()) {
                    System.out.println("No ratings yet.");
                } else {
                    for (Rating rating : driverRatings) {
                        System.out.println(rating);
                    }
                }
                System.out.println("Driver reputation: " + driver.getReputation());

                System.out.println("\nRatings for passenger (" + passenger.getLastName() + "):");
                List<Rating> passengerRatings = system.getRatingsForUser(passenger);
                if (passengerRatings.isEmpty()) {
                    System.out.println("No ratings yet.");
                } else {
                    for (Rating rating : passengerRatings) {
                        System.out.println(rating);
                    }
                }
                System.out.println("Passenger reputation: " + passenger.getReputation());
                continue;
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Wrong choice, enter 1, 2, 3, or 4!");
                continue;
            }

            // Input score
            int score = 0;
            boolean validScore = false;
            while (!validScore) {
                System.out.print("Enter the score (1 to 5): ");
                try {
                    score = Integer.parseInt(scanner.nextLine());
                    if (score >= 1 && score <= 5) {
                        validScore = true;
                    } else {
                        System.out.println("Score must be between 1 and 5, try again!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Enter a number, not text, that's wrong!");
                }
            }

            // Input comment
            System.out.print("Enter a comment (or press Enter to leave blank): ");
            String comment = scanner.nextLine();
            if (comment.trim().isEmpty()) {
                comment = "No comment";
            }

            // Create the rating
            try {
                if (choice == 1) {
                    system.passengerRatesDriver(passenger, driver, score, comment);
                    System.out.println("Rating added: " + score + "/5, \"" + comment + "\" for the driver.");
                } else {
                    system.driverRatesPassenger(driver, passenger, score, comment);
                    System.out.println("Rating added: " + score + "/5, \"" + comment + "\" for the passenger.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("All good, work by Member 3 validated!");
    }
}