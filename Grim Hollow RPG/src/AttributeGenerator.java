///import java.util.Arrays;
///import java.util.Random;
///import java.util.Scanner;
///
///public class AttributeGenerator {
///
///    private int[] availableChoices = new int[6];
///    private Scanner scanner = new Scanner(System.in);
///
///            public int[] generateAttributePoints() {
///                int[] attributePoints = new int[6];
///                int[] rolledNumbers = new int[9];
///
///                System.out.println("Rolling Attribute Dice");
///                Random random = new Random();
///
///                for (int i = 0; i < 9; i++) {
///                    int[] diceRolls = new int[4];
///
///                    for (int j = 0; j < 4; j++) {
///                    diceRolls[j] = random.nextInt(6) + 1;
///                    }
///
///                Arrays.sort(rolledNumbers);
///                int total = diceRolls[1] + diceRolls[2] + diceRolls[3];
///                rolledNumbers[i] = total;
///
///            }
///
///                Arrays.sort(rolledNumbers);
///                int[] sortedNumbers = new int[6];
///                for (int i = 0; i < 6; i++) {
///                    sortedNumbers[i] = rolledNumbers[8 - i];
///                }
///
///                int[] finalNumbers = Arrays.copyOfRange(sortedNumbers, 3, 9);
///
///
///
///                for (int i = 0; i < 6; i++) {
///                    int choice = promptForAttributeChoice(i);
///                    attributePoints[choice] = finalNumbers[i];
///                }
///
///                return attributePoints;
///
///            }
///
///
///    private int promptForAttributeChoice(int index) {
///        while (true) {
///            System.out.println("Available attribute points: " + availableChoicesToString());
///            System.out.println("Choose an attribute (0-5) to allocate a point to: ");
///            int choice = scanner.nextInt();
///            scanner.nextLine();
///            if (choice >= 0 && choice <= 5 && availableChoices[choice] > 0) {
///                return choice;
///            } else {
///                System.out.println("Invalid choice. Please choose an attribute with available points.");
///            }
///        }
///    }
///
///    private String availableChoicesToString() {
///        StringBuilder sb = new StringBuilder();
///        for (int i = 0; i < 6; i++) {
///            sb.append("attribute ").append(i).append(": ").append(availableChoices[i]).append("points");
///                    if (i < 5) {
///                        sb.append(",  ");
///            }
///        }
///        return sb.toString();
///    }
///
///}


//import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner;
//
//public class AttributeGenerator {
//
//    private int[] availableChoices = {18, 18, 18, 18, 18, 18}; // Initialize with starting points
//    private Scanner scanner = new Scanner(System.in);
//
//    public int[] generateAttributePoints() {
//        int[] attributePoints = new int[6];
//        int[] rolledNumbers = new int[9];
//
//        System.out.println("Rolling Attribute Dice");
//        Random random = new Random();
//
//        for (int i = 0; i < 9; i++) {
//            int[] diceRolls = new int[4];
//
//            for (int j = 0; j < 4; j++) {
//                diceRolls[j] = random.nextInt(6) + 1;
//            }
//
//            Arrays.sort(diceRolls);
//            int total = diceRolls[1] + diceRolls[2] + diceRolls[3];
//            rolledNumbers[i] = total;
//        }
//
//        Arrays.sort(rolledNumbers);
//        int[] sortedNumbers = new int[6];
//        for (int i = 0; i < 6; i++) {
//            sortedNumbers[i] = rolledNumbers[8 - i];
//        }
//
//        int[] finalNumbers = Arrays.copyOfRange(sortedNumbers, 3, 9);
//
//        for (int i = 0; i < 6; i++) {
//            int choice = promptForAttributeChoice(i);
//            attributePoints[choice] = finalNumbers[i];
//        }
//
//        return attributePoints;
//    }
//
//    private int promptForAttributeChoice(int index) {
//        while (true) {
//            System.out.println("Available attribute points: " + availableChoicesToString());
//            System.out.println("Choose an attribute (0-5) to allocate a point to: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            if (choice >= 0 && choice <= 5 && availableChoices[choice] > 0) {
//                availableChoices[choice]--; // Decrement available points
//                return choice;
//            } else {
//                System.out.println("Invalid choice. Please choose an attribute with available points.");
//            }
//        }
//    }
//
//    private String availableChoicesToString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 6; i++) {
//            sb.append("attribute ").append(i).append(": ").append(availableChoices[i]).append(" points");
//            if (i < 5) {
//                sb.append(",  ");
//            }
//        }
//        return sb.toString();
//    }
//}

import java.util.Arrays;
import java.util.Random;

public class AttributeGenerator {
    private Random random = new Random();

    public int[] generateAttributePoints() {
        int[] attributePoints = new int[9];

        for (int i = 0; i < 9; i++) {
            attributePoints[i] = roll4d6AndSum();
        }

        Arrays.sort(attributePoints);

        return Arrays.copyOfRange(attributePoints, 3, 9);
    }

    private int roll4d6AndSum() {
        int[] diceRolls = new int[4];

        for (int j = 0; j < 4; j++) {
            diceRolls[j] = random.nextInt(6) + 1;
        }

        // Sort the rolls in ascending order
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - i; j++) {
                if (diceRolls[j] > diceRolls[j + 1]) {
                    int temp = diceRolls[j];
                    diceRolls[j] = diceRolls[j + 1];
                    diceRolls[j + 1] = temp;
                }
            }
        }


        Arrays.sort(diceRolls);


        int total = diceRolls[1] + diceRolls[2] + diceRolls[3];

        return total;
    }
}