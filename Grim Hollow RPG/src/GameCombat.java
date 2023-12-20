import java.util.Random;

public class GameCombat {
    public void executeAttack(CombatInterface attacker, CombatInterface target) {
        Random rand = new Random();
        int attackRoll = rand.nextInt(20) + 1;

        if (attackRoll >= target.getArmorClass()) {
            int damage = rand.nextInt(6) + 1;

            target.takeDamage(damage);

        } else {
        }

    }
}