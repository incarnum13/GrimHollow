public abstract class Armor {
    protected String type;
    protected int defenseBonus;

    public Armor(String type, int defenseBonus) {
        this.type = type;
        this.defenseBonus = defenseBonus;

    }

    public int getDefenseBonus() {
        return defenseBonus;

    }

    public static class ChainMailArmor extends Armor {
        public ChainMailArmor() {
            super("Chainmail", 1);
        }
    }

    public static class LeatherArmor extends Armor {
        public LeatherArmor() {
            super("leather", 1);
        }
    }

}

