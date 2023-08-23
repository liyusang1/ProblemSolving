//프로그래머스 피보나치 수
//Memoization
public class Programmers106_Memoization {
    public int solution(int n) {

        int[] arr = new int[n + 1];
        arr[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Programmers106_Memoization test = new Programmers106_Memoization();
        System.out.println(test.solution(3));
    }
}

