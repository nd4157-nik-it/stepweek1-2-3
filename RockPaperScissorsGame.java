import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final int TOTAL_ROUNDS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] playerMoves = new String[TOTAL_ROUNDS];
        String[] computerMoves = new String[TOTAL_ROUNDS];
        String[] results = new String[TOTAL_ROUNDS];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Rock-Paper-Scissors Game ===");

        for (int round = 0; round < TOTAL_ROUNDS; round++) {

            System.out.print("\nRound " + (round + 1)
                    + " - Enter Rock, Paper, or Scissors: ");

            String playerMove = scanner.nextLine().trim();

            if (!isValidMove(playerMove)) {
                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
                round--;
                continue;
            }

            String computerMove = generateComputerMove();
            String result = playRound(playerMove, computerMove);

            playerMoves[round] = formatMove(playerMove);
            computerMoves[round] = computerMove;
            results[round] = result;

            System.out.println("Player: " + playerMoves[round]);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        printSummary(playerMoves, computerMoves, results,
                wins, losses, draws);

        scanner.close();
    }

    // Generates a random computer move.
    public static String generateComputerMove() {
        Random random = new Random();

        int randomIndex = random.nextInt(MOVES.length);

        return MOVES[randomIndex];
    }

    // Determines the winner of a round.
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock")
                && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper")
                && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors")
                && computerMove.equalsIgnoreCase("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    // Checks whether the player's move is valid.
    public static boolean isValidMove(String move) {
        return move.equalsIgnoreCase("Rock")
                || move.equalsIgnoreCase("Paper")
                || move.equalsIgnoreCase("Scissors");
    }

    // Formats the move correctly.
    public static String formatMove(String move) {
        return move.substring(0, 1).toUpperCase()
                + move.substring(1).toLowerCase();
    }

    // Prints the final scoreboard.
    public static void printSummary(
            String[] playerMoves,
            String[] computerMoves,
            String[] results,
            int wins,
            int losses,
            int draws) {

        System.out.println("\n========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < playerMoves.length; i++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        double winPercentage = (wins * 100.0) / playerMoves.length;

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);
    }
}