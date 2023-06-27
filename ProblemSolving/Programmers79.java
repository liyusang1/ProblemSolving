import java.util.*;

public class Programmers79 {
    public int[] solution(int n, long left, long right) {

        int [] answer = new int[(int) (right-left+1)];

        int index = 0;
        for(long i=left; i<=right; i++ ){
            long temp = Math.max(i/n,i%n)+1;
            answer[index] = (int)temp;
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers79 test = new Programmers79();

        System.out.println(Arrays.toString(test.solution(3, 2, 5)));
        System.out.println(Arrays.toString(test.solution(4, 7, 14)));
    }
}
