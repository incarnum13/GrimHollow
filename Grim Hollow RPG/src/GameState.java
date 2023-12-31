import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GameState implements Serializable {
    private String characterName;
    private String characterGender;
    private String characterRace;
    private String characterClass;
    private int[] abilityScores;
    private String currentLocation;
    private boolean gameOver;
    private boolean exitRequested;
    private Map<String, Object> inventory;
    private int hitPoints; // Added field
    private int armorClass; // Added field
    private int initiative; // Added field
    private int speed; // Added field

    public GameState(String characterName, String characterGender, String characterRace,
                     String characterClass, int[] abilityScores, String startingLocation) {
        this.characterName = characterName;
        this.characterGender = characterGender;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.abilityScores = abilityScores;
        this.currentLocation = startingLocation;
        this.gameOver = false;
        this.exitRequested = false;
        this.inventory = new HashMap<>();
        this.inventory.put("Gold", 0);
        this.hitPoints = 100; // Example value, adjust as needed
        this.armorClass = 10; // Example value
        this.initiative = 10; // Example value
        this.speed = 5; // Example value
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterGender() {
        return characterGender;
    }

    public void setCharacterGender(String characterGender) {
        this.characterGender = characterGender;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(String characterRace) {
        this.characterRace = characterRace;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int[] getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(int[] abilityScores) {
        this.abilityScores = abilityScores;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isExitRequested() {
        return exitRequested;
    }

    public void setExitRequested(boolean exitRequested) {
        this.exitRequested = exitRequested;
    }

    public Map<String, Object> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Object> inventory) {
        this.inventory = inventory;
    }

    public CharacterAttributes getPlayerAttributes() {
        return new CharacterAttributes(
                abilityScores[0], // Strength
                abilityScores[1], // Dexterity
                abilityScores[2], // Constitution
                abilityScores[3], // Intelligence
                abilityScores[4], // Wisdom
                abilityScores[5]  // Charisma
        );
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}