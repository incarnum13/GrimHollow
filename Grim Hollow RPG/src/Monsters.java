import java.util.List;

public class Monsters implements CombatInterface {
    private String name;
    public CharacterAttributes attributes;
    private int hitPoints;
    private int armorClass;
    private List<String> locations;
    private double spawnChance;

    public Monsters(String name, CharacterAttributes attributes, int hitPoints, int armorClass) {
        this.name = name;
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

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public double getSpawnChance() {
        return spawnChance;
    }

    public void setSpawnChance(double spawnChance) {
        this.spawnChance = spawnChance;
    }

    public String getName() {
        return name;
    }

    public CharacterAttributes getAttributes() {
        return attributes;
    }

    // Nested classes for specific monster types
    public static class Goblin extends Monsters {
        private String specialAbility;

        public Goblin(String name, CharacterAttributes attributes, int hitPoints, int armorClass, String specialAbility) {
            super(name, attributes, hitPoints, armorClass);
            this.specialAbility = specialAbility;
            this.attributes = attributes; // Ensure attributes are set
        }

        public void useSpecialAbility() {
            // Implementation of special ability
        }
    }

    public static class Gnoll extends Monsters {
        private String specialAbility;

        public Gnoll(String name, CharacterAttributes attributes, int hitPoints, int armorClass, String specialAbility) {
            super(name, attributes, hitPoints, armorClass);
            this.specialAbility = specialAbility;
            this.attributes = attributes; // Ensure attributes are set
        }

        public void useSpecialAbility() {
            // Implementation of special ability
        }
    }

    // Additional monster types can be added similarly...
}
