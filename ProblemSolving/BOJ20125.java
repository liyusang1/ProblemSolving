import java.util.*;
import java.io.*;

public class BOJ20125 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int head_x = -1, head_y = -1, heart_x = -1, heart_y = -1;

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N + 1][N + 1];

        for(int x = 1; x <= N; x++) {
            String str = br.readLine();
            for(int y = 1; y <= N; y++) {
                char c = str.charAt(y - 1);
                if(c == '*' && head_x == -1) {
                    head_x = x;
                    head_y = y;
                    heart_x = x + 1;
                    heart_y = y;
                }
                map[x][y] = c;
            }
        }

        sb.append(heart_x)
            .append(' ')
            .append(heart_y)
            .append('\n');

        int left_arm = 0;
        for(int i = heart_y - 1; i > 0; i--) {
            if(map[heart_x][i] != '*') {
                break;
            }
            left_arm++;
        }

        sb.append(left_arm).append(' ');

        int right_arm = 0;
        for(int i = heart_y + 1; i <= N; i++) {
            if(map[heart_x][i] != '*') {
                break;
            }
            right_arm++;
        }

        sb.append(right_arm).append(' ');

        int wrist = 0;
        for(int i = heart_x + 1; i <= N; i++) {
            if(map[i][heart_y] != '*') {
                break;
            }
            wrist++;
        }

        sb.append(wrist).append(' ');

        int left_leg = 0;
        for(int i = wrist + heart_x + 1; i <= N; i++) {
            if(map[i][heart_y - 1] != '*') {
                break;
            }
            left_leg++;
        }

        sb.append(left_leg).append(' ');

        int right_leg = 0;
        for(int i = wrist + heart_x + 1; i <= N; i++) {
            if(map[i][heart_y + 1] != '*') {
                break;
            }
            right_leg++;
        }

        sb.append(right_leg);
        System.out.println(sb.toString());
    }
}
