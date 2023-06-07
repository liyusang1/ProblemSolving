import java.util.*;

public class Programmers48 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        for (int i = 0; i<strings.length; i++){
            answer[i] = strings[i].charAt(n)+strings[i];
        }

        Arrays.sort(answer);

        for (int i = 0; i<strings.length; i++){
            answer[i] = answer[i].substring(1);
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers48 test = new Programmers48();
        System.out.println(Arrays.toString(test.solution(new String[]{"sun", "bed", "car" }, 1)));
        System.out.println(Arrays.toString(test.solution(new String[]{"abce", "abcd", "cdx" }, 2)));
    }
}
