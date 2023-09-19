import java.util.*;

public class Programmers_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        if (topping.length == 1) {
            return 0;
        }

        int a[] = new int[topping.length - 1];
        int b[] = new int[topping.length - 1];

        int[] numbers = new int[10_000 + 1];
        int temp = 0;

        for (int i = 0; i < topping.length - 1; i++) {

            if (numbers[topping[i]] == 0) { //새로운 맛 인경우
                temp++;
            }
            numbers[topping[i]]++;
            a[i] = temp;
        }

        //첫번째 토핑만큼 빼주고
        numbers[topping[0]]--;
        if (numbers[topping[0]] == 0) {
            temp--;
        }

        //마지막 토핑을 더해준 누적합을구한다
        if (numbers[topping[topping.length - 1]] == 0) {
            temp++;
        }
        numbers[topping[topping.length - 1]]++;
        
        int bIndex = 0;
        b[bIndex] = temp;
        bIndex++;

        for (int i = 1; i <= topping.length - 2; i++) {
            if (numbers[topping[i]] - 1 == 0) { //더이상 그맛이 없는 경우
                temp--;
            }
            numbers[topping[i]]--;
            b[bIndex] = temp;
            bIndex++;
        }

        //[1, 2, 2, 3, 3, 4, 4]
        //[4, 4, 4, 3, 3, 2, 1]

        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_롤케이크자르기 test = new Programmers_롤케이크자르기();
        System.out.println(test.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));

    }
}

