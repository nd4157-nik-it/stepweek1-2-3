import java.util.Scanner;

public class TeamBmiCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of people: ");

        try {
            int numberOfPeople = scanner.nextInt();

            if (numberOfPeople <= 0) {
                System.out.println("Number of people must be greater than zero.");
                return;
            }

            double[] heights = new double[numberOfPeople];
            double[] weights = new double[numberOfPeople];

            for (int i = 0; i < numberOfPeople; i++) {

                System.out.println("\nPerson " + (i + 1));

                System.out.print("Enter height in meters: ");
                heights[i] = scanner.nextDouble();

                System.out.print("Enter weight in kilograms: ");
                weights[i] = scanner.nextDouble();

                if (heights[i] <= 0 || weights[i] <= 0) {
                    System.out.println(
                            "Height and weight must be greater than zero.");

                    i--;
                }
            }

            printWellnessReport(heights, weights);

        } catch (java.util.InputMismatchException exception) {

            System.out.println(
                    "Invalid input. Please enter numeric values.");

        } finally {
            scanner.close();
        }
    }

    // Calculates BMI.
    public static double calculateBmi(double height, double weight) {

        return weight / (height * height);
    }

    // Determines BMI status.
    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Prints the complete wellness report.
    public static void printWellnessReport(
            double[] heights,
            double[] weights) {

        System.out.println("\n================ WELLNESS REPORT ================");

        System.out.printf(
                "%-10s %-15s %-15s %-12s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        System.out.println(
                "---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = calculateBmi(heights[i], weights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf(
                    "%-10d %-15.2f %-15.2f %-12.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    status);
        }
    }
}