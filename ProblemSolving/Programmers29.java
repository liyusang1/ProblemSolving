import java.util.*;

public class Programmers29 {

    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        answer = answer.replaceAll("[.]{2,}",".");
        answer = answer.replaceAll("^[.]|[.]$","");

        if (answer.length() == 0) {
            answer += "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);

            if (answer.substring(answer.length() - 1).equals(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        if (answer.length() <= 2) {
            char temp = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += temp;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Programmers29 test = new Programmers29();
        System.out.println(test.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(test.solution("z-+.^."));
        System.out.println(test.solution("=.="));

    }
}
