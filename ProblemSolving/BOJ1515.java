import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1515 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int i = 1;

        while (num.length()!=0) {
            String cnt = Integer.toString(i);
            while (cnt.length() > 0) {
                if (num.length()!=0 && num.charAt(0)==cnt.charAt(0)) {
                    num = num.substring(1);
                }
                cnt = cnt.substring(1);
            }
            i++;
        }
        System.out.println(i-1);
    }
}
