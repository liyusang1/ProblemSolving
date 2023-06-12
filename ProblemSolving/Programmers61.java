import java.util.*;

public class Programmers61 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        if (minerals.length > (picks[0] + picks[1] + picks[2]) * 5) {
            minerals = Arrays.copyOfRange(minerals, 0, (picks[0] + picks[1] + picks[2]) * 5);
        }

        int weight[][];

        if (minerals.length % 5 == 0) {
            weight = new int[(minerals.length / 5)][4];
        } else {
            weight = new int[(minerals.length / 5) + 1][4];
        }

        int temp = 0;
        int nowWeight = 0;
        int index = 0;

        for (int k = 0; k < minerals.length; k++) {
            switch (minerals[k]) {
                case "diamond":
                    nowWeight += 25;
                    weight[index][1] += 1;
                    break;
                case "iron":
                    nowWeight += 5;
                    weight[index][2] += 1;
                    break;
                case "stone":
                    nowWeight += 1;
                    weight[index][3] += 1;
                    break;
            }
            temp += 1;
            if (temp == 5 || k == minerals.length - 1) {
                weight[index][0] = nowWeight;
                index += 1;
                temp = 0;
                nowWeight = 0;
            }
        }

        int diaCount = picks[0];
        int ironCount = picks[1];
        int stoneCount = picks[2];
        int currentPick = 0;
        int maxPick = (diaCount + ironCount + stoneCount) * 5;
        int nowIndex = 0;

        Arrays.sort(weight, Comparator.comparingInt(o -> o[0] * -1));

        while (currentPick + 5 <= maxPick && nowIndex < index) {

            if (diaCount >= 1) {
                diaCount -= 1;
                answer += weight[nowIndex][1] + weight[nowIndex][2] + weight[nowIndex][3];
                currentPick += 5;
                nowIndex += 1;
                continue;
            }
            if (ironCount >= 1) {
                ironCount -= 1;
                answer += weight[nowIndex][1] * 5 + weight[nowIndex][2] + weight[nowIndex][3];
                currentPick += 5;
                nowIndex += 1;
                continue;
            }
            if (stoneCount >= 1) {
                stoneCount -= 1;
                answer += weight[nowIndex][1] * 25 + weight[nowIndex][2] * 5 + weight[nowIndex][3];
                currentPick += 5;
                nowIndex += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers61 test = new Programmers61();

        System.out.println(test.solution(
                new int[]{1, 3, 2},
                new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}
        ));

        System.out.println(test.solution(
                new int[]{1, 1, 1},
                new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
        ));

        System.out.println(test.solution(
                new int[]{0, 1, 1},
                new String[]{"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"}
        ));

        System.out.println(test.solution(
                new int[]{0, 1, 0},
                new String[]{"diamond", "iron", "iron", "iron", "iron", "diamond", "diamond", "iron", "iron", "iron"}
        ));

    }
}
