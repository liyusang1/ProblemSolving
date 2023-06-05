import java.util.Arrays;

public class Programmers40 {
    public boolean solution(int x) {
        boolean answer = true;
        int firstX = x;

        int[] arr = new int[5];
        int temp = 10000;

        for (int i = 0; i < 5; i++) {
            arr[i] = x / temp;
            x %= temp;
            temp /= 10;
        }

        int number = 0;
        for (int i : arr) {
            number += i;
        }

        if (firstX % number != 0) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers40 test = new Programmers40();
        System.out.println(test.solution(11));
    }
}
