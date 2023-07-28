import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers_숫자문자열과영단어 {
    public int solution(String s) {

        String[] number = new String[]{
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };

        for (int i = 0; i < number.length; i++) {
            if (s.contains(number[i])) {
                s = s.replace(number[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Programmers_숫자문자열과영단어 test = new Programmers_숫자문자열과영단어();
        System.out.println(test.solution("one4seveneight"));
    }
}

