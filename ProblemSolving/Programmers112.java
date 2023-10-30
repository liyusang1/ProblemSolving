import java.util.*;
//다음큰 숫자
public class Programmers112 {
    public int solution(int n) {
        String temp = Integer.toBinaryString(n);
        int curCount = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                curCount++;
            }
        }

        while (true) {
            n++;
            String cur = Integer.toBinaryString(n);
            int oneCount = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == '1') {
                    oneCount++;
                }
            }

            if (oneCount == curCount) {
                break;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        Programmers112 test = new Programmers112();
        System.out.println(test.solution(78));
    }
}

