public class Programmers46 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(' ');
                index = 0;
                continue;
            } else if (index % 2 == 0) {
                index += 1;
                answer.append(s.substring(i, i + 1).toUpperCase());
            } else {
                index += 1;
                answer.append(s.substring(i, i + 1).toLowerCase());
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Programmers46 test = new Programmers46();
        System.out.println(test.solution("try hello world"));
        System.out.println(test.solution("try hello  world   "));
    }
}
