import java.util.*;

//프로그래머스 영어 끝말잇기
public class Programmers100 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int count = 1;
        int turn = 1;
        String compareWord = "";

        Map<String, Integer> wordCheck = new HashMap<>();

        for (String word : words) {
            if (wordCheck.containsKey(word)) {
                answer[0] = count;
                answer[1] = turn;
                break;
            } else {
                wordCheck.put(word, 1);
            }
            if (compareWord.equals("")) {

            } else if (compareWord.charAt(compareWord.length() - 1) != word.charAt(0)) {
                answer[0] = count;
                answer[1] = turn;
                break;
            }
            compareWord = word;

            count++;
            if (count > n) {
                count = 1;
                turn++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers100 test = new Programmers100();
        System.out.println(Arrays.toString(test.solution(3, new String[]{
                "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }
}

