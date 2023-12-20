import java.util.Scanner;

public class LunaTemple {
    private Scanner scanner = new Scanner(System.in);
    private String description;
    private String[] activities;

    public LunaTemple() {
        this.description = "You wake up in a serene temple dedicated to the goddess Luna. It's peaceful, with soft light filtering through stained glass windows.";
        this.activities = new String[]{"Pray at the altar", "Speak with the priestess", "Explore the temple grounds", "Meditate in the tranquility"};
    }

    public void enterTemple(GameState characterState) {
        System.out.println(description);
        boolean inTemple = true;

        while (inTemple) {
            System.out.println("What would you like to do?");
            for (int i = 0; i < activities.length; i++) {
                System.out.println((i + 1) + ". " + activities[i]);
            }

            System.out.println("Enter your choice (or 0 to exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                inTemple = false;
            } else if (choice > 0 && choice <= activities.length) {
                System.out.println("you chose to: " + activities[choice - 1]);
            } else {
                System.out.println("Invalid choice. please try again.");
            }


        }
    }

}
