public class Programmers41 {
    public int solution(long tempNum) {
        int answer = 0;

        while (tempNum != 1) {
            if (tempNum % 2 == 0) {
                tempNum /= 2;
                answer += 1;
            } else if (tempNum % 2 != 0) {
                tempNum = tempNum * 3 + 1;
                answer += 1;
            }
            if (answer == 500) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers41 test = new Programmers41();
        System.out.println(test.solution(6));
        System.out.println(test.solution(16));
        System.out.println(test.solution(626331));
    }
}
