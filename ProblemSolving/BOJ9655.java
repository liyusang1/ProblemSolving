import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9655 {
    public static void main(String[] args) throws IOException {

        // BufferedReader 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 라인 값 3 입력
        int num = Integer.parseInt(br.readLine());

        int result = 0;

        while (num > 0) {
            if (num - 3 > 0) {
                num = num - 3;
            } else {
                num = num - 1;
            }

            result++;
        }

        //System.out.println(result);

        if (result % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
