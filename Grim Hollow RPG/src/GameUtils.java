public class GameUtils {

    public static boolean checkAndPerformSave(String input, GameState gameState) {
        if ("save".equals(input.toLowerCase().trim())) {
            Save_Load.saveGame(gameState, gameState.getCharacterName() + ".save");
            System.out.println("Game saved.");
            return true;
        }
        return false;
    }

}