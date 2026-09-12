import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String text = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayResult = isPalindromeArrayReversal(text);

        System.out.println("\n========== PALINDROME RESULTS ==========");

        System.out.println("Iterative: "
                + getResultMessage(iterativeResult));

        System.out.println("Recursive: "
                + getResultMessage(recursiveResult));

        System.out.println("Array Reversal: "
                + getResultMessage(arrayResult));

        if (iterativeResult == recursiveResult
                && recursiveResult == arrayResult) {

            System.out.println("\nAll three approaches agree.");
        }

        scanner.close();
    }

    // Iterative palindrome check.
    public static boolean isPalindromeIterative(String text) {

        String cleanText = text.replaceAll("\\s+", "")
                .toLowerCase();

        int left = 0;
        int right = cleanText.length() - 1;

        while (left < right) {

            if (cleanText.charAt(left)
                    != cleanText.charAt(right)) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Recursive palindrome check.
    public static boolean isPalindromeRecursive(String text) {

        String cleanText = text.replaceAll("\\s+", "")
                .toLowerCase();

        return checkPalindromeRecursively(
                cleanText, 0, cleanText.length() - 1);
    }

    private static boolean checkPalindromeRecursively(
            String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkPalindromeRecursively(
                text, left + 1, right - 1);
    }

    // Character-array reversal approach.
    public static boolean isPalindromeArrayReversal(String text) {

        String cleanText = text.replaceAll("\\s+", "")
                .toLowerCase();

        char[] characters = cleanText.toCharArray();

        reverseCharacterArray(characters);

        String reversedText = new String(characters);

        return cleanText.equals(reversedText);
    }

    // Reverses a character array.
    public static void reverseCharacterArray(char[] characters) {

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            char temporary = characters[left];

            characters[left] = characters[right];
            characters[right] = temporary;

            left++;
            right--;
        }
    }

    // Converts boolean result into readable output.
    public static String getResultMessage(boolean result) {

        return result ? "Palindrome" : "Not Palindrome";
    }
}