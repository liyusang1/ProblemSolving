import java.util.*;

public class Programmers90 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        if (yellow == 1) {
            return new int[]{3, 3};
        }

        List<int[]> list = getGcd(yellow);

        for (int[] i : list) {
            if (((i[0] + 2) * 2 + (i[1] + 2) * 2 - 4) == brown) {
                answer[0] = i[0] + 2;
                answer[1] = i[1] + 2;
                break;
            }
        }

        return answer;
    }


    public List<int[]> getGcd(int number) {
        List<int[]> list = new ArrayList();

        for (int i = 1; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                if (number / i != i) {
                    list.add(new int[]{number / i, i});
                } else {
                    list.add(new int[]{number / i, number / i});
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {

        Programmers90 test = new Programmers90();
        System.out.println(Arrays.toString(test.solution(24, 24)));
        System.out.println(Arrays.toString(test.solution(12, 3)));
        System.out.println(Arrays.toString(test.solution(12, 4)));


    }
}

