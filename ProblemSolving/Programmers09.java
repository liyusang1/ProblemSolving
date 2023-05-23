public class Programmers09 {
    public int solution(String t, String p) {
        int answer = 0;

        int len = p.length();

        for (int i = 0; i <= t.length() - len; i++) {

            long number1 = Long.parseLong((t.substring(i, len+i)));
            long number2 = Long.parseLong((p));

            if (number1 <= number2) {
                answer += 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Programmers09 test = new Programmers09();
        System.out.println(test.solution("3141592", "271"));
        System.out.println(test.solution("500220839878", "7"));
        System.out.println(test.solution("10203", "15"));
    }
}
