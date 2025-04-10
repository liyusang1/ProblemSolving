package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1515 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int number = 0;
        int index = 0;

        while (number++ <= 30000) {
            String str = String.valueOf(number);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == s.charAt(index)) {
                    index++;
                }
                if (index == s.length()) {
                    System.out.println(number);
                    return;
                }
            }
        }
    }
}
