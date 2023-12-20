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

    public GameState(String characterName, String characterGender, String characterRace, String characterClass, int[] abilityScores) {
        this.characterName = characterName;
        this.characterGender = characterGender;
        this.characterRace = characterRace;
        this.characterClass = characterClass;
        this.abilityScores = abilityScores;
        this.currentLocation = "Start";
        this.gameOver = false;
        this.exitRequested = false;
        this.inventory = new HashMap<>();
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterGender() {
        return characterGender;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public int[] getAbilityScores() {
        return abilityScores;
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
}
