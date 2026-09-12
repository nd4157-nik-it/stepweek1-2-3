import java.util.Scanner;

public class CustomerNameReverser {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");

        String customerName = scanner.nextLine();

        String reversedName =
                reverseCustomerName(customerName);

        System.out.println("\nOriginal Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }

    // Reverses the customer name.
    public static String reverseCustomerName(
            String customerName) {

        char[] characters = customerName.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            char temporary = characters[left];

            characters[left] = characters[right];
            characters[right] = temporary;

            left++;
            right--;
        }

        return new String(characters);
    }
}