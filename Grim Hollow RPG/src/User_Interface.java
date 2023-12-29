import java.util.Scanner;

public class User_Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;

        while (!exitGame) {
            System.out.println("Welcome to Grimhollow!");
            System.out.println("Type 'Start New Game', 'Load Game', or 'quit game' to proceed.");


            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "start new game":
                case "start":
                case "new":
                case "new game":
                    startNewGame();
                    break;
                case "load":
                case "load game":
                case "continue":
                    System.out.println("Enter character name to load:");
                    String characterNameToLoad = scanner.nextLine();
                    Save_Load.loadGame(characterNameToLoad);
                    break;
                case "quit":
                case "quit game":
                    exitGame = true;
                    break;
                default:
                    System.out.println("please try again");
                    break;

            }
        }
        scanner.close();
        System.out.println("Thank you for playing!");

    }

    public static void startNewGame() {
        CharacterCreation characterCreation = new CharacterCreation();
        GameState gameState = characterCreation.createNewCharacter();

        boolean gameRunning = true;

        while (gameRunning) {
            String currentLocation = gameState.getCurrentLocation();

            switch (currentLocation) {
                case "Luna Temple":
                    LunaTemple temple = new LunaTemple();
                    temple.enterTemple(gameState);
                    break;
                case "Oldsewers":
                    Oldsewers dungeon = new Oldsewers();
                    dungeon.exploreDungeon(gameState);
                    break;
            }

            if (gameState.isGameOver() || gameState.isExitRequested()) {
                gameRunning = false;
            }
        }
    }
}