import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CombatManager {
    private List<Combatant> combatants = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public CombatManager() {

    }

    public void addCombatant(Combatant combatant) {
        combatants.add(combatant);
    }

    public void startCombat() {
        rollInitiative();
        sortCombatantsByInitiative();
        runCombat();
    }

    private void rollInitiative() {
        for (Combatant combatant : combatants) {
            combatant.rollForInitiative();
        }
    }

    private void sortCombatantsByInitiative() {
        Collections.sort(combatants, (c1, c2) -> c2.getInitiative() -c1.getInitiative());
    }

    private void runCombat() {
        boolean combatInProgress = true;
        while (combatInProgress) {
            for (Combatant combatant : combatants) {
                if (combatant.getHitPoints() <= 0) {
                    continue;
                }

                executeTurn(combatant);

                combatInProgress = checkCombatStatus();
                if (!combatInProgress) {
                    break;
                }
            }
        }
        System.out.println("Combat has ended.");
    }

    private void executeTurn(Combatant combatant) {
    if (combatant.isPlayerControlled()) {
        playerTakeTurn(combatant);
        } else {
        goblinTakeTurn(combatant);
        }
    }

    private void goblinTakeTurn(Combatant goblin) {
        Combatant target = selectRandomPlayerControlledOpponent();
        goblin.attack(target);
    }

    private Combatant selectRandomPlayerControlledOpponent() {
        List<Combatant> playerControlled = combatants.stream()
                .filter(Combatant::isPlayerControlled)
                .collect(Collectors.toList());
        Random rand = new Random();
        return playerControlled.get(rand.nextInt(playerControlled.size()));
    }


    private void playerTakeTurn(Combatant player) {
        boolean turnCompleted = false;
        while (!turnCompleted) {
            System.out.println("It's your turn. Choose an action:");
            System.out.println("1: Attack");
            System.out.println("2: Run Away");
            System.out.println("3: Use Item");
            System.out.println("4: Use Ability");
            System.out.println("5: Use Skill");
            System.out.println("6: Interact with Environment");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Attack
                    attackAction(player);
                    turnCompleted = true;
                    break;
                case 2: // Run Away
                    runAwayAction(player);
                    turnCompleted = true;
                    break;
                case 3: // Use Item
                    useItemAction(player);
                    turnCompleted = true;
                    break;
                case 4: // Use Ability
                    useAbilityAction(player);
                    turnCompleted = true;
                    break;
                case 5: // Use Skill
                    useSkillAction(player);
                    turnCompleted = true;
                    break;
                case 6: // Interact with Environment
                    interactEnvironmentAction(player);
                    turnCompleted = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void attackAction(Combatant player) {
        // Similar to existing attack logic in playerTakeTurn
    }

    private void runAwayAction(Combatant player) {
        // Logic to escape combat or move to a safe location
    }

    private void useItemAction(Combatant player) {
        // Logic for player to select and use an item
    }

    private void useAbilityAction(Combatant player) {
        // Logic for using a special ability
    }

    private void useSkillAction(Combatant player) {
        // Logic for using a skill, like stealth or persuasion
    }

    private void interactEnvironmentAction(Combatant player) {
        // Logic for interacting with the combat environment
    }

    private boolean checkCombatStatus() {
        boolean anyPlayerCotrolledAlive = combatants.stream().anyMatch(c -> c.isPlayerControlled() && c.getHitPoints() > 0);
        boolean anyEnemiesAlive = combatants.stream().anyMatch(c -> !c.isPlayerControlled() && c.getHitPoints() > 0);
        return anyPlayerCotrolledAlive && anyEnemiesAlive;

    }

    private Combatant selectRandomOpponent(Combatant combatant) {
    Random rand = new Random();
    List<Combatant> opponets = new ArrayList<>(combatants);
    opponets.remove(combatant);
    return opponets.get(rand.nextInt(opponets.size()));
    }
}
