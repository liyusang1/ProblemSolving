import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2503 {

    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[1000];
        for (int i = 123; i < 1000; i++) {
            String str = Integer.toString(i);
            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
                continue;
            }
            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2)
                || str.charAt(1) == str.charAt(2)) {
                continue;
            }
            check[i] = true;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int t = 123; t < 1000; t++) {
                if (check[t]) {
                    int nstrike = 0;
                    int nball = 0;

                    for (int first = 0; first < 3; first++) {
                        char split1 = Integer.toString(number).charAt(first);

                        for (int second = 0; second < 3; second++) {
                            char split2 = Integer.toString(t).charAt(second);

                            if (split1 == split2 && first == second) {
                                nstrike++;
                            } else if (split1 == split2 && first != second) {
                                nball++;
                            }
                        }
                    }
                    check[t] = (strike == nstrike && ball == nball);
                }
            }
        }

        int answer = 0;
        for (int i = 123; i < 1000; i++) {
            if (check[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
