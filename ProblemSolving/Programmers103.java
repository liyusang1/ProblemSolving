//프로그래머스 JadenCase 문자열 만들기
public class Programmers103 {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");

        for (String i : arr) {
            if (i.length() == 0) {
                answer += " ";
            } else {
                String temp = i.substring(0, 1).toUpperCase();
                String temp2 = i.substring(1).toLowerCase();
                answer += temp + temp2 + " ";
            }
        }

        if (answer.substring(s.length() - 1).equals(" ")) {
            return answer;
        } else {
            return answer.substring(0, answer.length() - 1);
        }
    }

    public static void main(String[] args) {
        Programmers103 test = new Programmers103();
        System.out.println(test.solution("3people unFollowed me"));
    }
}

