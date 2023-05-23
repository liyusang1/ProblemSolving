import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers08 {

    public String solution(String s, String skip, int index) {
        String answer = "";

        String [] word = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"
                , "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        List<String> words = new ArrayList<>();
        for(String i : word){
            words.add(i);
        }

        String [] skipWord = skip.split("");
        String [] wordString = s.split("");

        for (int i = 0; i < skipWord.length; i++) {
            words.remove(skipWord[i]);
        }

        for (int i = 0; i < s.length(); i++) {
            int temp = words.indexOf(wordString[i]) + index;

            while (temp >= words.size()) {
                temp -= words.size();
            }
            answer += words.get(temp);
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers08 test = new Programmers08();
        System.out.println(test.solution("aukks", "wbqd", 5));
    }
}
