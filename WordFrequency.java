import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }

    public static void printFilteredWordFrequency(String feedback) {
        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (isStopWord(word, stopWords)) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        frequency.entrySet()
                .stream()
                .sorted((first, second) ->
                        second.getValue().compareTo(first.getValue()))
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + ": " + entry.getValue()
                        )
                );
    }

    public static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }

        return false;
    }
}