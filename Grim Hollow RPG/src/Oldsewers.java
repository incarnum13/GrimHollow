import java.util.Scanner;

public class Oldsewers {
    private Scanner scanner = new Scanner(System.in);

    public void exploreDungeon(GameState gameState) {
        System.out.println("You have entered a dark and mysterious dungeon.");

        boolean exploringOldsewers = true;
        while (exploringOldsewers) {
            System.out.println("What would you like to do?");
            System.out.println("1. Explore further");
            System.out.println("2. Exit dungeon");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    System.out.println("You explore deeper into the dungeon...");
                    // Add more dungeon exploration logic here
                    break;
                case 2:
                    System.out.println("You exit the dungeon and return to the previous location.");
                    exploringOldsewers = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Update the current location in gameState after exiting the dungeon
        // For example, gameState.setCurrentLocation("Luna Temple");
    }
}