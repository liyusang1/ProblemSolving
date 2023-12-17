import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2607 {
    static final char ALPHABET_OFFSET = 'A';

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String src = bufferedReader.readLine();

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) words.add(bufferedReader.readLine());

        int result = 0;

        for (String word : words) {
            int count = getSimilarityCount(src, word);

            if ((src.length() == word.length() && (src.length() == count || src.length() - 1 == count)) ||
                (src.length() == word.length() - 1 && word.length() - 1 == count) ||
                (src.length() == word.length() + 1 && word.length() == count)) result++;
        }

        System.out.println(result);
    }
    private static int getSimilarityCount(String src, String word) {
        int[] alphabetCount = new int[26];
        int count = 0;

        for (int i = 0; i < src.length(); i++) {
            alphabetCount[src.charAt(i) - ALPHABET_OFFSET]++;
        }

        for (int i = 0; i < word.length(); i++) {
            if (alphabetCount[word.charAt(i) - ALPHABET_OFFSET] > 0) {
                count++;
                alphabetCount[word.charAt(i) - ALPHABET_OFFSET]--;
            }
        }

        return count;
    }
}
