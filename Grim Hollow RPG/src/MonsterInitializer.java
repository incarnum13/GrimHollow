import java.util.Arrays;
import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class MonsterInitializer {
    private Map<String, Supplier<Monsters>> monsterRegistry = new HashMap<>();

    public MonsterInitializer() {
        monsterRegistry.put("Goblin", this::initializeGoblin);
        monsterRegistry.put("Gnoll", this::initializeGnoll);
    }

    public Monsters initializeGoblin() {
        CharacterAttributes goblinAttributes = new CharacterAttributes(10, 10, 10, 10, 10, 10);
        Monsters.Goblin goblin = new Monsters.Goblin("Gobbo", goblinAttributes, 12, 15, "Sneak Attack");

        goblin.setLocations(Arrays.asList("Oldsewers", "Dark Forest"));
        goblin.setSpawnChance(0.5); // 50% chance

        System.out.println("Initialized Goblin: " + goblin.getName() + " with attributes: " + goblin.getAttributes()); // Debug print

        return goblin;
    }

    public Monsters initializeGnoll() {
        CharacterAttributes gnollAttributes = new CharacterAttributes(12, 12, 12, 14, 14, 14);
        Monsters.Gnoll gnoll = new Monsters.Gnoll("Hyena-Face", gnollAttributes, 22, 11, "Desert Clan");

        gnoll.setLocations(Arrays.asList("Dark Forest", "Desert"));
        gnoll.setSpawnChance(0.25); // 25% chance

        System.out.println("Initialized Gnoll: " + gnoll.getName() + " with attributes: " + gnoll.getAttributes()); // Debug print

        return gnoll;
    }


    public List<Monsters> getAllMonstersForLocation(String location) {
           List<Monsters> monstersForLocation = new ArrayList<>();
           for (Supplier<Monsters> initializer : monsterRegistry.values()) {
               Monsters monster = initializer.get();
               if (monster.getLocations().contains(location)) {
                   monstersForLocation.add(monster);
               }
           }

           return monstersForLocation;
    }

}