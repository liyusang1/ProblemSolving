import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        int[] countAlp = new int[40];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] words = s.toUpperCase().toCharArray();

        for (char word : words) {
            countAlp[word - 'A']++;
        }

        int max = 0;
        int index = 0;
        boolean check = true;

        for (int i = 0; i < countAlp.length; i++) {
            if (max < countAlp[i]) {
                max = countAlp[i];
                index = i;
            }
        }

        for (int i = 0; i < countAlp.length; i++) {
            if (i != index && max == countAlp[i]) {
                check = false;
                System.out.println("?");
                break;
            }
        }

        if (check) {
            System.out.println((char) ('A' + index));
        }
    }
}
