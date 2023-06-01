public class Programmers25 {

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (getGcdCount(i) % 2 == 0) {
                answer += i;
            }
            else{
                answer -= i;
            }
        }

        return answer;
    }

    public int getGcdCount(int n) {

        int answer = 0;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer += 1;
                if (n / i != i) {
                    answer += 1;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Programmers25 test = new Programmers25();

        System.out.println(test.solution(13, 17));
        System.out.println(test.solution(24, 27));
    }
}
