import java.util.Scanner;

public class CharacterCreation {
    private final Scanner scanner = new Scanner(System.in);

    public GameState createNewCharacter() {
        System.out.println("Welcome to character Creation");

        String characterName = promptForCharacterName();
        String characterGender = promptForGender();
        String characterRace = promptForRace();
        String characterClass = promptForClass();
        int[] abilityScores = generateAttributePoints();
        int[] allocatedAttributes = allocateAttributePoints(abilityScores);

        return new GameState(characterName, characterGender, characterRace, characterClass, allocatedAttributes);

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

        switch (choice) {
            case 1:
                return "Human";
            case 2:
                return "Elf";
            case 3:
                return "Dwarf";
            case 4:
                return "Halfling";
            case 5:
                return "Dragonborn";
            case 6:
                return "Gnome";
            case 7:
                return "Half-Elf";
            case 8:
                return "Half-Orc";
            case 9:
                return "Tiefling";
            default:
                System.out.println("Invalid choice. Please choose again.");
                return promptForRace();
        }
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

            switch (choice) {
                case 1:
                    return "Barbarian";
                case 2:
                    return "Bard";
                case 3:
                    return "Cleric";
                case 4:
                    return "Druid";
                case 5:
                    return "Fighter";
                case 6:
                    return "Monk";
                case 7:
                    return "Paladin";
                case 8:
                    return "Ranger";
                case 9:
                    return "Rogue";
                case 10:
                    return "Sorcerer";
                case 11:
                    return "Warlock";
                case 12:
                    return "Wizard";
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    return promptForClass(); // Recursive call for invalid input
            }

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


}
