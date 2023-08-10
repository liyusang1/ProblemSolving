import java.util.*;

public class Programmers_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int firstPointer = 0;
        int secondPointer = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum == k) {
                if (min > secondPointer - firstPointer) { //최소길이 인지 확인
                    min = secondPointer - firstPointer;
                    answer[0] = firstPointer;
                    answer[1] = secondPointer;
                } else if (secondPointer < sequence.length - 1) { //최소 길이가 아니면 다시 찾아야함
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
        Programmers_연속된부분수열의합 test = new Programmers_연속된부분수열의합();
        System.out.println((Arrays.toString(test.solution(new int[]{1, 2, 3, 4, 5}, 7))));
        System.out.println((Arrays.toString(test.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5))));
        System.out.println((Arrays.toString(test.solution(new int[]{2, 2, 2, 2, 2}, 6))));
    }
}

