public class Monsters implements CombatInterface {
    private String name;
    private CharacterAttributes attributes;
    private int hitPoints;
    private int armorClass;

    public Monsters(
                    String name,
                    CharacterAttributes attributes,
                    int hitPoints,
                    int armorClass

                    ) {

                    this.name = name;
                    this.hitPoints = hitPoints;
                    this.armorClass = armorClass;

                    }

    @Override    public int getArmorClass() { return armorClass; }
    @Override    public int getHitPoints() { return hitPoints; }
    @Override    public void takeDamage(int damage) { hitPoints -= damage;}



    public static class Goblin extends Monsters {
        private String specialAbility;

        public Goblin(String name, CharacterAttributes attributes, int hitPoints, int armorClass, String specialAbility) {
            super(name, attributes, hitPoints, armorClass);
            this.specialAbility = specialAbility;
        }
        public void useSpecialAbility() {}
    }

    public static class Gnoll extends Monsters {
        private String specialAbility;

        public Gnoll(String name, CharacterAttributes attributes, int hitPoints, int armorClass, String specialAbility) {
            super(name, attributes, hitPoints, armorClass);
            this.specialAbility = specialAbility;
        }
        public void useSpecialAbility() {}
    }
}
