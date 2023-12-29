public class Weapon {
    private String name;
    private String damageType;
    private int damageDie;
    private int damageDieCount;

    public Weapon(String name, String damageType, int damageDieCount, int damageDie) {
        this.name = name;
        this.damageType = damageType;
        this.damageDieCount = damageDieCount;
        this.damageDie = damageDie;


    }

    public static class Sword extends Weapon {
        public Sword(String name, int damageDieCount, int damageDie) {
            super(name, "Slashing", damageDieCount, damageDie);
        }
    }

    public static class Axe extends Weapon {
        public Axe (String name, int damageDieCount, int damageDie) {
            super(name, "Slashing", damageDieCount, damageDie);
        }
    }

    public static final Sword DEFAULT_SWORD = new Sword("Default Sword", 1, 6);
    public static final Axe DEFAULT_AXE = new Axe("Default Axe", 1, 8);


}
