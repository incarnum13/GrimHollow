import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameState gameState = null; // Initially, there is no game state
        CombatManager combatManager = new CombatManager();
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("Enter command (new, load, save, quit):");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "new":
                    // Start a new game
                    CharacterCreation characterCreation = new CharacterCreation();
                    gameState = characterCreation.createNewCharacter();
                    // Additional setup if needed
                    break;
                case "save":
                    if (gameState != null) {
                        Save_Load.saveGame(gameState, "gameSave.dat");
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
            }
            CharacterCreation characterCreation = new CharacterCreation();

            GameState playerGameState = characterCreation.createNewCharacter();
            CharacterAttributes playerAttributes = new CharacterAttributes(
                    playerGameState.getAbilityScores()[0], // Strength
                    playerGameState.getAbilityScores()[1], // Dexterity
                    playerGameState.getAbilityScores()[2], // Constitution
                    playerGameState.getAbilityScores()[3], // Intelligence
                    playerGameState.getAbilityScores()[4], // Wisdom
                    playerGameState.getAbilityScores()[5]  // Charisma
            );

            Combatant playerCharacter = new Combatant(
                    playerGameState.getCharacterName(),
                    playerAttributes, 100, 15, 10, 5, true
            ); // Player-controlled


            CharacterAttributes npcAttributes = new CharacterAttributes(8, 10, 12, 14, 16, 18);
            Combatant npc = new Combatant(
                    "NPC Name",
                    npcAttributes,
                    80, 12, 8, 4, false); // NPC

            combatManager.addCombatant(playerCharacter);
            combatManager.addCombatant(npc);

            combatManager.startCombat();
        }
    }
}