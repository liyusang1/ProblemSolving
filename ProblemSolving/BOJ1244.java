import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1244 {

    static int [] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        map = new int[count + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= count; i++) map[i] = Integer.parseInt(st.nextToken());

        int studentCount = Integer.parseInt(br.readLine());

        List<String> inputList = new ArrayList<>();
        for (int i = 0; i <studentCount; i++) inputList.add(br.readLine());

        for (String input: inputList) {
            st = new StringTokenizer(input);
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                int tmp = number;
                while (number <= count) {
                    press(number);
                    number += tmp;
                }
            }
            else {
                press(number);
                int left = number - 1;
                int right = number + 1;
                while (((left > 0) && (right <= count)) && (map[left] == map[right])) {
                    press(left);
                    press(right);
                    left--;
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++){
            sb.append(map[i]);
            if ((i % 20) == 0) sb.append("\n");
            else sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    static void press(int number) {
        map[number] = map[number]^1;
    }
}