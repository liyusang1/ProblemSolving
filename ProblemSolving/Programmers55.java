import java.util.*;

public class Programmers55 {
    public int[] solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        double[] rate = new double[N];

        for (int nowStage = 1; nowStage <= N; nowStage++) {

            int arriveCnt = 0;
            int clearCnt = 0;

            for (int i = 0; i < stages.length; i++) {
                if (stages[i] >= nowStage) {
                    arriveCnt += 1;
                }

                if (stages[i] > nowStage) {
                    clearCnt += 1;
                }
            }
            if (arriveCnt == 0) {
                rate[nowStage - 1] = 0;
            } else {
                rate[nowStage - 1] = (double) (arriveCnt - clearCnt) / arriveCnt;
            }
        }

        double min = -100;
        int minIndex = 0;
        for (int i = 0; i < rate.length; i++) {
            for (int j = 0; j < rate.length; j++) {
                if (min < rate[j]) {
                    min = rate[j];
                    minIndex = j;
                }
            }
            answer.add(minIndex + 1);
            rate[minIndex] = -100;
            min = -100;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        Programmers55 test = new Programmers55();
        System.out.println((test.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println((test.solution(4, new int[]{4, 4, 4, 4, 4})));
    }
}
