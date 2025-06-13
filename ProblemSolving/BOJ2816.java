import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder answer = new StringBuilder();
        int index = 0;

        for(int i = 0; i < N; i++) {
            if(arr[i].equals("KBS1")) {
                break;
            }
            index++;
            answer.append("1");
        }

        for(int i = index; i > 0; i--) {
            answer.append("4");
            String temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        index = 0;
        answer.append("1");
        for(int i = 1; i < N; i++) {
            if(arr[i].equals("KBS2")) {
                break;
            }
            index++;
            answer.append("1");
        }

        for(int i = 0; i < index; i++) {
            answer.append("4");
        }

        System.out.println(answer);
    }
}
