public class MonsterInitializer {

    public void initializeEncounter() {
        CharacterAttributes goblinAttributes = new CharacterAttributes(10, 10, 10, 10, 10, 10);
        Monsters.Goblin goblin = new Monsters.Goblin("Gobbo", goblinAttributes, 12, 15, "Sneak Attack");

        CharacterAttributes gnollAttributes = new CharacterAttributes(12, 12, 12, 14, 14, 14);
        Monsters.Gnoll gnoll = new Monsters.Gnoll("Hyena-Face", gnollAttributes, 22, 11, "Desert Clan");

        // Add these monsters to the game encounter or store them for later use
        // ...
    }

    // Other methods for initializing different monsters or encounters
}