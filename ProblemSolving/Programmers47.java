public class Programmers47 {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(s.charAt(i));
                continue;
            }
            if ((int) s.charAt(i) + n > 90 && (int) s.charAt(i) <= 90) {
                int temp = (int) s.charAt(i) + n - 90;
                answer.append((char) ('A' + temp - 1));
            } else if ((int) s.charAt(i) + n > 122) {
                int temp = (int) s.charAt(i) + n - 122;
                answer.append((char) ('a' + temp - 1));
            } else {
                answer.append((char) (s.charAt(i) + n));
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Programmers47 test = new Programmers47();
        System.out.println(test.solution("AB", 1));
        System.out.println(test.solution("z", 1));
        System.out.println(test.solution("a B z", 4));
        System.out.println(test.solution("A B Z", 25));
    }
}
