public class Programmers18 {

    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n / a > 0) {
            answer += (n / a) * b;
            n = (n / a) * b + n % a;
        }
        return answer;
    }

    public static void main(String[] args) {

        Programmers18 test = new Programmers18();
        System.out.println(test.solution(2, 1, 20));
        System.out.println(test.solution(3, 1, 20));

    }
}
