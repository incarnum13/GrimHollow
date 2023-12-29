import java.util.Scanner;

public class CharacterCreation {
    public final Scanner scanner = new Scanner(System.in);

    public GameState createNewCharacter() {
        System.out.println("Welcome to character Creation");

        String characterName = promptForCharacterName();
        String characterGender = promptForGender();
        String characterRace = promptForRace();
        String characterClass = promptForClass();
        int[] abilityScores = generateAttributePoints();
        int[] allocatedAttributes = allocateAttributePoints(abilityScores);
        String startingLocation = promptForStartingLocation();
        System.out.println("Starting location is: " + startingLocation);

        return new GameState(characterName, characterGender, characterRace, characterClass, allocatedAttributes, startingLocation);

    }

    private String promptForGender() {
        System.out.println("Choose your gender");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Non-binary");

        System.out.print("Enter the number of your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Recursive call for invalid input
        return switch (choice) {
            case 1 -> "Male";
            case 2 -> "Female";
            case 3 -> "Non-binary";
            default -> {
                System.out.println("Invalid choice. Please choose again.");
                yield promptForGender();
            }
        };
    }

    private String promptForCharacterName() {
        System.out.println("Enter your character's name:");
        return scanner.nextLine();
    }

    private String promptForRace() {
        System.out.println("Choose your character's race:");
        System.out.println("1. Human");
        System.out.println("2. Elf");
        System.out.println("3. Dwarf");
        System.out.println("4. Halfling");
        System.out.println("5. Dragonborn");
        System.out.println("6. Gnome");
        System.out.println("7. Half-Elf");
        System.out.println("8. Half-Orc");
        System.out.println("9. Tiefling");

        System.out.print("Enter the number of your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        return switch (choice) {
            case 1 -> "Human";
            case 2 -> "Elf";
            case 3 -> "Dwarf";
            case 4 -> "Halfling";
            case 5 -> "Dragonborn";
            case 6 -> "Gnome";
            case 7 -> "Half-Elf";
            case 8 -> "Half-Orc";
            case 9 -> "Tiefling";
            default -> {
                System.out.println("Invalid choice. Please choose again.");
                yield promptForRace();
            }
        };
    }

        private String promptForClass() {
            System.out.println("Choose your character's class:");
            System.out.println("1. Barbarian");
            System.out.println("2. Bard");
            System.out.println("3. Cleric");
            System.out.println("4. Druid");
            System.out.println("5. Fighter");
            System.out.println("6. Monk");
            System.out.println("7. Paladin");
            System.out.println("8. Ranger");
            System.out.println("9. Rogue");
            System.out.println("10. Sorcerer");
            System.out.println("11. Warlock");
            System.out.println("12. Wizard");
            // Add any additional classes here

            System.out.print("Enter the number of your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            // Recursive call for invalid input
            return switch (choice) {
                case 1 -> "Barbarian";
                case 2 -> "Bard";
                case 3 -> "Cleric";
                case 4 -> "Druid";
                case 5 -> "Fighter";
                case 6 -> "Monk";
                case 7 -> "Paladin";
                case 8 -> "Ranger";
                case 9 -> "Rogue";
                case 10 -> "Sorcerer";
                case 11 -> "Warlock";
                case 12 -> "Wizard";
                default -> {
                    System.out.println("Invalid choice. Please choose again.");
                    yield promptForClass();
                }
            };

        }
            private int[] generateAttributePoints() {
                AttributeGenerator attributeGenerator = new AttributeGenerator();
                return attributeGenerator.generateAttributePoints();

            }

    private int[] allocateAttributePoints(int[] attributePoints) {
        int[] allocatedAttributes = new int[6];
        String[] attributeNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        boolean allocationConfirmed;

        do {
            boolean[] usedPoints = new boolean[attributePoints.length]; // Track used rolls
            System.out.println("Please allocate your attribute rolls:");
            for (int point : attributePoints) {
                System.out.print(point + ", ");
            }
            System.out.println();

            for (int i = 0; i < allocatedAttributes.length; i++) {
                System.out.println("Assign a roll to " + attributeNames[i] + ":");
                for (int j = 0; j < attributePoints.length; j++) {
                    if (!usedPoints[j]) {
                        System.out.println((j + 1) + ". " + attributePoints[j]);
                    }
                }

                boolean validChoice = false;
                while (!validChoice) {
                    System.out.print("Enter the number of your choice: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid choice. Please select an unused roll.");
                        scanner.nextLine();
                        System.out.println("Enter the number of your choice: ");
                    }

                    int choice = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    if (choice >= 0 && choice < attributePoints.length && !usedPoints[choice]) {
                        allocatedAttributes[i] = attributePoints[choice];
                        usedPoints[choice] = true;
                        validChoice = true;
                    } else {
                        System.out.println("Invalid choice. Please select an unused roll.");
                    }
                }
            }

            System.out.println("\nYour allocated attributes are:");
            for (int i = 0; i < allocatedAttributes.length; i++) {
                System.out.println(attributeNames[i] + ": " + allocatedAttributes[i]);
            }

            System.out.println("Are you happy with these choices? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            allocationConfirmed = response.equals("yes");

            if (allocationConfirmed) {
                System.out.println("Character creation complete! Starting your adventure...");
            } else {
                System.out.println("Let's try allocating your attributes again...");
            }

        } while (!allocationConfirmed);

        return allocatedAttributes;
    }

    private String promptForStartingLocation() {
        while (true) {
        System.out.println("Choose your starting location:");
        System.out.println("1. Luna Temple");
        System.out.println("2. Oldsewers Dungeon");
        System.out.print("Enter the number of your choice: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

        switch (choice) {
            case 1:
                return "Luna Temple";
            case 2:
                return "Oldsewers";
            default:
                System.out.println("Invalid choice. Please choose again.");
                break;

            }
        } else{
                System.out.println("Invalid choice. Please choose again.");

            }
        }
    }


}
