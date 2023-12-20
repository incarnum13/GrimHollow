public class Combatant implements CombatInterface{
    private CharacterAttributes attributes;
    private int hitPoints;
    private int armorClass;

    public Combatant(CharacterAttributes attributes, int hitPoints, int armorClass) {
        this.attributes = attributes;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
    }

    @Override
    public int getArmorClass() {
        return armorClass;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void takeDamage(int damage) {
        hitPoints -= damage;
    }



}
