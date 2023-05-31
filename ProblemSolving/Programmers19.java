public class Programmers19 {

    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer += 1;
                    }

                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers19 test = new Programmers19();
        System.out.println(test.solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(test.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(test.solution(new int[]{-1, 1, -1, 1}));
    }
}
