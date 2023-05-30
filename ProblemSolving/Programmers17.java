public class Programmers17 {

    public int solution(String s) {
        int answer = 1;

        int sameCount = 0;
        int diffCount = 0;

        char temp = s.charAt(0);

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == temp) {
                sameCount += 1;
            } else {
                diffCount += 1;
            }

            if (sameCount == diffCount) {
                answer += 1;

                sameCount = 0;
                diffCount = 0;
                if (i + 1 < s.length()) {
                    temp = s.charAt(i + 1);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers17 test = new Programmers17();
        System.out.println(test.solution("banana"));
        System.out.println(test.solution("abracadabra"));
        System.out.println(test.solution("aaabbaccccabba"));
    }
}
