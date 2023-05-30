import java.util.Stack;

public class Programmers16 {

    public int solution(String[] babbling) {
        int answer = 0;
        String[] can = new String[]{"aya", "ye", "woo", "ma"};
        String[] cant = new String[]{"ayaaya", "yeye", "woowoo", "mama"};

        for (String i : babbling) {

            boolean check = true;
            for (String j : cant) {
                if (i.contains(j)) {
                    check = false;
                    break;
                }
            }

            if (!check) {
                continue;
            }

            for (String k : can) {
                i = i.replace(k, " ");
            }

            i = i.trim();

            if (i.length() == 0) {
                answer += 1;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers16 test = new Programmers16();
        System.out.println(test.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}
