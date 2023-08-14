import java.util.*;

public class Programmers_광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        //광물의 길이가 곡괭이를 합친것보다 많다면 그만큼 배열을 짜름
        if (minerals.length > (picks[0] + picks[1] + picks[2]) * 5) {
            minerals = Arrays.copyOfRange(minerals, 0, (picks[0] + picks[1] + picks[2]) * 5);
        }

        int weight[][];

        //5개씩 쪼개서 2차원에 배열에 저장
        if (minerals.length % 5 == 0) {
            weight = new int[(minerals.length / 5)][4];
        } else {
            weight = new int[(minerals.length / 5) + 1][4];
        }

        int temp = 0;
        int nowWeight = 0;
        int index = 0;

        //2차원에 배열에 [돌곡괭이로 했을때 피로도,다이아광물 ,아이언 광물,돌 광물] ex [85,3,2,0] 저장
        //                                                                  [31,1,1,1]
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
            if (temp == 5 || k == minerals.length - 1) { //5개씩 쪼갯으니 temp가 5까지 가거나, 최대길이에 도달한 경우
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

        //피로도가 가장 높은 순으로 내림차순 정렬
        Arrays.sort(weight, Comparator.comparingInt(o -> o[0] * -1));

        //피로도가 높은순으로 정렬되어 있기 때문에 반복문을 돌면서 계산만 해주면됨, 피로도가 정렬되어있기 때문에 다이아 곡괭이 먼저 사용할 수 있음 사용
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
        Programmers_광물캐기 test = new Programmers_광물캐기();
        System.out.println(test.solution(new int[]{1, 3, 2}, new String[]{
                "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"
        }));
    }
}

