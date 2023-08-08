import java.util.*;

public class Programmers_실패율 {
    public int[] solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        double[] rate = new double[N];

        for (int nowStage = 1; nowStage <= N; nowStage++) {

            int arriveCnt = 0;
            int clearCnt = 0;

            for (int i = 0; i < stages.length; i++) {
                if (stages[i] >= nowStage) { //같거나 큰 도착 횟수
                    arriveCnt += 1;
                }

                if (stages[i] > nowStage) { //큰 클리어 횟수
                    clearCnt += 1;
                }
            }
            if (arriveCnt == 0) { //도착한 사람이 없으면 실패율 0
                rate[nowStage - 1] = 0;
            } else {
                rate[nowStage - 1] = (double) (arriveCnt - clearCnt) / arriveCnt;
            }
        }

        double min = Integer.MIN_VALUE;
        int minIndex = 0;
        for (int i = 0; i < rate.length; i++) { //실패율 배열에서 가장 높은 순서대로
            for (int j = 0; j < rate.length; j++) {
                if (min < rate[j]) {
                    min = rate[j];
                    minIndex = j;
                }
            }
            answer.add(minIndex + 1);
            rate[minIndex] = Integer.MIN_VALUE;
            min = Integer.MIN_VALUE;
        }

        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    public static void main(String[] args) {
        Programmers_실패율 test = new Programmers_실패율();
        System.out.println((test.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
}

