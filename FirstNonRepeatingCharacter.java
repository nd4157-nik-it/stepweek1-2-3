import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    private static final int ASCII_SIZE = 256;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");

        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {

            System.out.println(
                    "No Non-Repeating Character Found");

        } else {

            System.out.println(
                    "First Non-Repeating Character: '"
                            + result + "'");

            System.out.println(
                    "ASCII Code: " + (int) result);
        }

        scanner.close();
    }

    // Finds the first character occurring exactly once.
    public static char findFirstNonRepeatingChar(String text) {

        int[] characterFrequency = new int[ASCII_SIZE];

        // Count character frequencies.
        for (int i = 0; i < text.length(); i++) {

            char currentCharacter = text.charAt(i);

            if (currentCharacter < ASCII_SIZE) {
                characterFrequency[currentCharacter]++;
            }
        }

        // Find the first character with frequency one.
        for (int i = 0; i < text.length(); i++) {

            char currentCharacter = text.charAt(i);

            if (currentCharacter < ASCII_SIZE
                    && characterFrequency[currentCharacter] == 1) {

                return currentCharacter;
            }
        }

        return '\0';
    }
}