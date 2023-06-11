import java.util.Arrays;

public class Programmers59 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int firstPointer = 0;
        int secondPointer = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum == k) {
                if (min > secondPointer - firstPointer) {
                    min = secondPointer - firstPointer;
                    answer[0] = firstPointer;
                    answer[1] = secondPointer;
                } else if (secondPointer < sequence.length - 1) {
                    secondPointer += 1;
                    sum += sequence[secondPointer];
                } else {
                    break;
                }
            } else if (sum < k && secondPointer < sequence.length - 1) {
                secondPointer += 1;
                sum += sequence[secondPointer];
            } else if (sum > k && firstPointer < sequence.length - 1) {
                sum -= sequence[firstPointer];
                firstPointer += 1;
            } else {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Programmers59 test = new Programmers59();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(test.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(test.solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }
}
