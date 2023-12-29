import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combatant implements CombatInterface{
    private CharacterAttributes attributes;
    private int hitPoints;
    private int armorClass;
    private int initiative;
    private int speed;
    private List<String> conditions;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private String name;
    private boolean isPlayerControlled;

    public Combatant(String name, CharacterAttributes attributes, int hitPoints, int armorClass, int initiative, int speed, boolean isPlayerControlled) {
        this.attributes = attributes;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.conditions = new ArrayList<>();
        this.equippedWeapon = Weapon.DEFAULT_SWORD;
        this.equippedArmor = new Armor.ChainMailArmor();
        this.name = name;
        this.isPlayerControlled = isPlayerControlled;

    }

    public int getInitiative()                                  {return initiative;}
    public void setInitiative                                   (int initiative) {this.initiative = initiative;}
    public int getSpeed()                                       {return speed;}
    public void setSpeed                                        (int speed) {this.speed = speed;}
    public List<String> getConditions()                         {return conditions;}
    public void addCondition(String condition)                  {conditions.add(condition);}
    public void removeCondition(String condition)               {conditions.remove(condition);}


    @Override
    public int getArmorClass() {
        int totalAC = armorClass + equippedArmor.getDefenseBonus();

        // Debug print to show how the total Armor Class is calculated
        System.out.println("Calculating AC: Base AC = " + armorClass + ", Bonus = " + equippedArmor.getDefenseBonus() + ", Total AC = " + totalAC);

        return totalAC;
    }

    @Override    public int getHitPoints()                       { return hitPoints; }
    @Override
    public void takeDamage(int damage) {
        hitPoints -= damage;
        System.out.println(name + " takes " + damage + " damage, remaining HP: " + hitPoints);
        if (hitPoints <= 0) {
            System.out.println(name + " has been defeated");
        }
    }

    public void defend() {
        addCondition("Defending");
    }
    public void useItem(Item item) { }

    public void equidWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
    }

    public String getName() {
        return name;
    }

    public void rollForInitiative() {
        Random rand = new Random();
        this.initiative = rand.nextInt(20) + 1 + attributes.getDexterityModifier();
    }

    public boolean isPlayerControlled() {
        return isPlayerControlled;
    }

    public boolean attack(Combatant target) {
        if (isAttackSuccessful(target)) {
            int damage = calculateDamage();
            target.takeDamage(damage);
            System.out.println("Attack hits for " + damage + "damage!");
            return true;
                        } else{
                System.out.println("Attack misses.");
                return false;
            }
    }

    private boolean isAttackSuccessful(Combatant target) {
            Random rand = new Random();
            int baseRoll = rand.nextInt(20) + 1;
            int attackRoll = baseRoll + attributes.getStrengthModifier(); // + equippedWeapon.getAttackBonus();

            System.out.println("Base Roll: " + baseRoll + ", Strength Modifier: " + attributes.getStrengthModifier() + ", Total Attack Roll: " + attackRoll + ", Target AC: " + target.getArmorClass());

            if (target.getConditions().contains(("Defending"))) {
                int secondRoll = rand.nextInt(20) + 1 + attributes.getStrengthModifier();
                attackRoll = Math.min(attackRoll, secondRoll);
            }


          return attackRoll >= target.getArmorClass();
    }

    private int calculateDamage() {
            Random rand = new Random();
            int damage = rand.nextInt(6) + 1;
            damage += attributes.getStrength();

            return damage;

    }

    public void initiateCombatWithGoblin(GameState gameState) {
    Combatant player = createPlayerCombatant(gameState);
    Combatant goblin = new Combatant("Goblin", new CharacterAttributes(10, 10, 10, 10, 10, 10), 10, 10, 10, 10, false);


    CombatManager combatManager = new CombatManager();
    combatManager.addCombatant(player);
    combatManager.addCombatant(goblin);
    combatManager.startCombat();

    }

    private Combatant createPlayerCombatant(GameState gameState) {
        CharacterAttributes playerAttributes = gameState.getPlayerAttributes();
        return new Combatant(gameState.getCharacterName(), playerAttributes, 100, 0, 10, 5, true);
    }


}
