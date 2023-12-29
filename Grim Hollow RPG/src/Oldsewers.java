import java.util.Scanner;
import java.util.Random;

public class Oldsewers {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void exploreDungeon(GameState gameState) {
        System.out.println("You have entered a dark and mysterious dungeon.");

        boolean exploringOldsewers = true;
        while (exploringOldsewers) {
            System.out.println("What would you like to do?");
            System.out.println("1. Explore further");
            System.out.println("2. Exit dungeon");

            System.out.println("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine();
                System.out.println("Enter your choice: ");
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (encounterGoblin()) {
                        System.out.println("You encounter a goblin!");
                        initiateCombatWithGoblin(gameState);
                    } else {
                        System.out.println("You continue exploring the dungeon.");
                    }
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

        gameState.setCurrentLocation("Oldsewers");
    }

    private boolean encounterGoblin() {
        System.out.println("encounterGoblin method called.");
        // Currently always returns true for testing purposes.
        // Later, replace with random chance logic.
        return true;

    }

    private void initiateCombatWithGoblin(GameState gameState) {
        System.out.println("initiateCombatWithGoblin method called."); // Debug print

        Combatant player = createPlayerCombatant(gameState);

        CharacterAttributes goblinAttributes = new CharacterAttributes(8, 10, 12, 14, 16, 18);
        Combatant goblin = new Combatant(
                "Goblin",
                goblinAttributes,
                5, 0, 8, 4, false);

        System.out.println("Goblin Armor Class: " + goblin.getArmorClass());// Debug print

        CombatManager combatManager = new CombatManager();
        combatManager.addCombatant(player);
        combatManager.addCombatant(goblin);
        combatManager.startCombat();
    }

        private Combatant createPlayerCombatant(GameState gameState) {
            CharacterAttributes playerAttributes = new CharacterAttributes(
                    gameState.getAbilityScores()[0], // Strength
                    gameState.getAbilityScores()[1], // Dexterity
                    gameState.getAbilityScores()[2], // Constitution
                    gameState.getAbilityScores()[3], // Intelligence
                    gameState.getAbilityScores()[4], // Wisdom
                    gameState.getAbilityScores()[5]  // Charisma
            );
            // this is the goblins stats
            int playerHP = 20;
            int playerArmorClass = 5;
            int playerInitiative = 10;
            int playerSpeed = 5;

            return new Combatant(gameState.getCharacterName(), playerAttributes, playerHP, playerArmorClass, playerInitiative, playerSpeed, true);

    }
}