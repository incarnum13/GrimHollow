import java.io.*;

public class Save_Load {

    public static void saveGame(GameState gameState) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(gameState.getCharacterName() + ".save"))) {
            out.writeObject(gameState);
            System.out.println("Game saved Successfully");
        } catch (IOException e) {
            System.out.println("error saving the game" + e.getMessage());

        }
    }

    public static GameState loadGame(String characterName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(characterName + ".save"))) {
            return (GameState) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the game: " + e.getMessage());
            return null;
        }
    }
}
