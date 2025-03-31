import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[] lights = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < len; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());
        int[][] studentArr = new int[studentCount][2];

        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            studentArr[i][0] = Integer.parseInt(st.nextToken());
            studentArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < studentArr.length; i++) {
            lights = change(lights, studentArr[i][0], studentArr[i][1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lights.length; i++) {
            sb.append(lights[i]);
            if (((i + 1) % 20) == 0) sb.append("\n");
            else sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static int[] change(int[] arr, int gender, int x) {
        if (gender == 1) {
            for (int i = 0; i < arr.length; i++) {
                if ((i + 1) % x == 0) {
                    if (arr[i] == 0) {
                        arr[i] = 1;
                    } else {
                        arr[i] = 0;
                    }
                }
            }
        } else {
            if (arr[x - 1] == 1) {
                arr[x - 1] = 0;
            } else {
                arr[x - 1] = 1;
            }

            for (int i = 1; (x - 1) + i < arr.length; i++) {
                if (x - 1 - i < 0) {
                    break;
                }

                if (arr[x - 1 - i] == arr[x - 1 + i]) {
                    if (arr[x - 1 - i] == 1) {
                        arr[x - 1 - i] = 0;
                    } else {
                        arr[x - 1 - i] = 1;
                    }
                    if (arr[x - 1 + i] == 1) {
                        arr[x - 1 + i] = 0;
                    } else {
                        arr[x - 1 + i] = 1;
                    }
                } else {
                    break;
                }
            }
        }

        return arr;
    }
}