import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Programmers57 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] string1 = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (temp.length() < n) {
                temp = '0' + temp;
            }
            string1[i] = temp;
        }

        for (int i = 0; i < string1.length; i++) {
            string1[i] = string1[i].replace("1", "#");
            string1[i] = string1[i].replace("0", " ");
        }

        return string1;
    }

    public static void main(String[] args) {

        Programmers57 test = new Programmers57();
        System.out.println(Arrays.toString(test.solution(5, new int[]{9, 20, 28, 18, 11}
                , new int[]{30, 1, 21, 17, 28})));

    }
}
