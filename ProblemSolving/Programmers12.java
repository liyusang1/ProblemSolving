import java.util.ArrayList;

public class Programmers12 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] list = new int[number];

        for (int i = 1; i <= number; i++) {
            list[i - 1] = getGcd(i);
        }

        for (int i : list) {
            if (i > limit) {
                answer += power;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    public static int getGcd(int n) {

        int sqrt = (int) Math.sqrt(n); // 값의 제곱근 저장
        ArrayList<Integer> arr = new ArrayList<>(); // 약수 받을 ArrayList

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) { // 약수 중 작은 수 저장
                arr.add(i);
                if (n / i != i) { // 약수 중 큰 수 저장
                    arr.add(n / i);
                }
            }
        }
        return arr.size();
    }

    public static void main(String[] args) {

        Programmers12 test = new Programmers12();

        System.out.println(test.solution(5, 3, 2));
        System.out.println(test.solution(10, 3, 2));
    }
}
