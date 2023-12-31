import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Oldsewers {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private MonsterInitializer initializer = new MonsterInitializer();

    public void exploreDungeon(GameState gameState) {
        System.out.println("You have entered the dark and mysterious Oldsewers.");
        boolean exploringOldsewers = true;

        while (exploringOldsewers) {
            System.out.println("What would you like to do?");
            System.out.println("1. Explore further");
            System.out.println("2. Exit dungeon");
            System.out.println("Type 'save' to save the game.");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            // Check for save command
            if (GameUtils.checkAndPerformSave(input, gameState)) {
                continue; // Skip rest of the loop if 'save' was entered
            }

            // Process other commands
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        Combatant monster = getRandomMonster("Oldsewers");
                        if (monster != null) {
                            System.out.println("You encounter a " + monster.getName() + "!");
                            initiateCombat(gameState, monster);
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'save'.");
            }
        }
    }

    private Combatant getRandomMonster(String location) {
        List<Monsters> possibleMonsters = initializer.getAllMonstersForLocation(location);
        System.out.println("Possible monsters for " + location + ": " + possibleMonsters.size()); // Debug print

        return possibleMonsters.stream()
                .peek(monster -> System.out.println("Considering monster: " + monster.getName() + " with spawn chance " + monster.getSpawnChance())) // Debug print
                .filter(monster -> random.nextDouble() < monster.getSpawnChance())
                .peek(monster -> System.out.println("Monster " + monster.getName() + " selected for spawn")) // Debug print
                .findAny()
                .map(this::convertMonsterToCombatant)
                .orElse(null);
    }

    private Combatant convertMonsterToCombatant(Monsters monster) {
        if (monster.getAttributes() == null) {
            System.out.println("Warning: Monster " + monster.getName() + " has null attributes.");
            return null;
        }
        return new Combatant(monster.getName(), monster.getAttributes(), monster.getHitPoints(), monster.getArmorClass(), 10, 5, false);
    }

    private void initiateCombat(GameState gameState, Combatant monster) {
        if (monster == null) {
            System.out.println("Warning: Monster is null, cannot initiate combat.");
            return;
        }
        Combatant player = createPlayerCombatant(gameState);
        CombatManager combatManager = new CombatManager();
        combatManager.addCombatant(player);
        combatManager.addCombatant(monster);
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

        int playerHP = gameState.getHitPoints();
        int playerArmorClass = gameState.getArmorClass();
        int playerInitiative = gameState.getInitiative();
        int playerSpeed = gameState.getSpeed();

        return new Combatant(gameState.getCharacterName(), playerAttributes, playerHP, playerArmorClass, playerInitiative, playerSpeed, true);
    }
}



