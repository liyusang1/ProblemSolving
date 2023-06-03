import java.util.Arrays;

public class Programmers33 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int j = 0;
        for (int[] command : commands) {
            int[] tempList = Arrays.copyOfRange(array,command[0] - 1, command[1]);
            Arrays.sort(tempList);
            answer[j] = tempList[command[2] - 1];
            j++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers33 test = new Programmers33();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
        System.out.println(Arrays.toString(test.solution(new int[]{1, 5, 2, 60, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
