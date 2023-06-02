import java.util.*;

public class Programmers32 {
    public List solution(int[] answers) {
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int onePoint = 0;
        int twoPoint = 0;
        int threePoint = 0;


        int j = 0;
        for (int i = 0; i < answers.length; i++) {
            if (j >= one.length) {
                j = 0;
            }

            if (answers[i] == one[j]) {
                onePoint += 1;
            }
            j += 1;
        }

        j = 0;
        for (int i = 0; i < answers.length; i++) {
            if (j >= two.length) {
                j = 0;
            }

            if (answers[i] == two[j]) {
                twoPoint += 1;
            }
            j += 1;
        }

        j = 0;
        for (int i = 0; i < answers.length; i++) {
            if (j >= three.length) {
                j = 0;
            }

            if (answers[i] == three[j]) {
                threePoint += 1;
            }
            j += 1;
        }

        int max = Math.max(onePoint, twoPoint);
        max = Math.max(max, threePoint);

        List<Integer> answer = new ArrayList<>();

        if (max == onePoint) {
            answer.add(1);
        }
        if (max == twoPoint) {
            answer.add(2);
        }
        if (max == threePoint) {
            answer.add(3);
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers32 test = new Programmers32();
        System.out.println((test.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println((test.solution(new int[]{1, 3, 2, 4, 2})));
    }
}
