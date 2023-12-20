public class CharacterAttributes {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int charisma;
    private int wisdom;

    public CharacterAttributes(int strength, int dexterity, int constitution, int intelligence, int charisma, int wisdom)
    {
        this.strength       = strength;
        this.dexterity      = dexterity;
        this.constitution   = constitution;
        this.intelligence   = intelligence;
        this.charisma       = charisma;
        this.wisdom         = wisdom;
    }

    public int getStrength()        { return strength; }
    public int getDexterity()       { return dexterity; }
    public int getConstitution()    { return constitution; }
    public int getIntelligence()    { return intelligence; }
    public int getCharisma()        { return charisma; }
    public int getWisdom()          { return wisdom; }

    public static int calculateModifier(int attributeScore) { return (attributeScore - 10) / 2; }

    public int getStrengthModifier()        { return calculateModifier(strength); }
    public int getDexterityModifier()       { return calculateModifier(dexterity); }
    public int getConstitutionModifier()    { return calculateModifier(constitution); }
    public int getIntelligenceModifier()    { return calculateModifier(intelligence); }
    public int getCharismaModifier()        { return calculateModifier(charisma); }
    public int getWisdomModifier()          { return calculateModifier(wisdom); }
}
