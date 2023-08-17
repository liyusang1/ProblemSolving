import java.util.*;
//이모티콘 할인행사
//문제 회고 *
//문제에서 주어진 array,emoticons size를 볼때 크기가 크지 않아서 모든 조건을 다 탐색하는 방법을 생각해보는 것이 중요했던것 같음 -> O(n^3) 시간복잡도를 가지고 있음에도 정답처리
//recursive 함수를 통해 이모티콘 할인의 경우의 수를 모두 생각하고 모든 경우의 수에서 가장 좋은 조건을 찾음, 이때 이모티콘의 최대길이는 7이여서 그냥 완전탐색을 해도 됨

public class Programmers_이모티콘할인행사 {
    List<String> list = new ArrayList<>(); //모든 경우의 수를 담기위한 list

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] discount = {1, 2, 3, 4};
        recur(discount, "", emoticons.length); // 1111, 1112, 1113, 1114, 1121, 1122, 1123, 1124, 1131, 1132, 1133, 1134, 1141, 1142, 1143, 1144, 1211, 1212, 1213, 1214, 1221, 1222, 1223, 1224......

        for (int i = 0; i < list.size(); i++) {
            int newUser = 0;
            int price = 0;

            int[] emoticonsPrice = new int[emoticons.length];
            int[] disCountPercentage = new int[emoticons.length];

            for (int j = 0; j < emoticonsPrice.length; j++) {
                emoticonsPrice[j] = (int) (emoticons[j] - (emoticons[j] * (Integer.parseInt(String.valueOf(list.get(i).charAt(j))) * 0.1))); //할인가격
                disCountPercentage[j] = Integer.parseInt(String.valueOf(list.get(i).charAt(j))) * 10; //할인률
            }

            for (int k = 0; k < users.length; k++) {
                int tempPrice = 0;

                for (int t = 0; t < emoticonsPrice.length; t++) {
                    if (users[k][0] <= disCountPercentage[t]) { //유저가 원하는 할인률 보다 크면 tempPrice에 임시저장
                        tempPrice += emoticonsPrice[t];
                    }
                }
                if (tempPrice >= users[k][1]) { //tempPrice가 가격을 초과했으면 이모티콘 플러스 가격가입자가 되야함
                    newUser++;
                } else { //그렇지 않다면 플러시 가입자가 아니고 그냥 매출만 증가
                    price += tempPrice;
                }
            }

            if (answer[0] < newUser) { //최상의 경우인지 조건탐색, 현재 이모티콘플러스가입자 수보다 많은가, 같다면 매출이 더 높은가 판단
                answer[0] = newUser;
                answer[1] = price;
            } else if (answer[0] == newUser && answer[1] < price) {
                answer[1] = price;
            }
        }

        return answer;
    }

    public void recur(int[] discount, String temp, int length) { //recursive함수를 통한 완전탐색으로 할인 할 수 있는 모든 경우의 수를 찾음
        if (temp.length() == length) {
            list.add(temp);
            return;
        }

        for (int i : discount) {
            recur(discount, temp + i, length);
        }
    }

    public static void main(String[] args) {
        Programmers_이모티콘할인행사 test = new Programmers_이모티콘할인행사();
        System.out.println(test.solution(new int[][]{
                        {40, 10000},
                        {25, 10000}}
                , new int[]{7000, 9000}));

        System.out.println(test.solution(new int[][]{
                        {40, 2900},
                        {23, 10000},
                        {11, 5200},
                        {5, 5900},
                        {40, 3100},
                        {27, 9200},
                        {32, 6900}

                }
                , new int[]{1300, 1500, 1600, 4900}));
    }
}

