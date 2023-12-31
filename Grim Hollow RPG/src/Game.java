import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameState gameState = null;
        CombatManager combatManager = new CombatManager();
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("Enter command (new, load, save, quit):");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "new":
                    CharacterCreation characterCreation = new CharacterCreation();
                    gameState = characterCreation.createNewCharacter();
                    // Initiate combat or other gameplay elements
                    break;
                case "save":
                    if (gameState != null) {
                        Save_Load.saveGame(gameState, "gameSave.dat");
                        System.out.println("Game state saved.");
                    } else {
                        System.out.println("No game state to save.");
                    }
                    break;
                case "load":
                    gameState = Save_Load.loadGame("gameSave.dat");
                    if (gameState == null) {
                        System.out.println("Failed to load game state.");
                    }
                    break;
                case "quit":
                    gameRunning = false;
                    break;
                default:
                    // Handle other inputs or game actions
                    break;
            }
        }
        scanner.close();
        System.out.println("Game over. Thanks for playing!");
    }


    private static void startInitialCombat(GameState gameState, CombatManager combatManager) {
        // Create player combatant
        Combatant playerCharacter = createPlayerCombatant(gameState);

        // Create initial enemy combatant for demonstration
        // In actual implementation, this should be replaced with actual game logic
        CharacterAttributes enemyAttributes = new CharacterAttributes(10, 10, 10, 10, 10, 10);
        Combatant enemy = new Combatant("Enemy", enemyAttributes, 20, 12, 10, 5, false);

        // Add combatants to combat manager and start combat
        combatManager.addCombatant(playerCharacter);
        combatManager.addCombatant(enemy);
        combatManager.startCombat();
    }

    private static Combatant createPlayerCombatant(GameState gameState) {
        CharacterAttributes playerAttributes = gameState.getPlayerAttributes();
        return new Combatant(
                gameState.getCharacterName(),
                playerAttributes,
                gameState.getHitPoints(),
                gameState.getArmorClass(),
                gameState.getInitiative(),
                gameState.getSpeed(),
                true);
    }
}