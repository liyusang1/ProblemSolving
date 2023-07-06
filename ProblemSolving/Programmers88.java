import java.util.Arrays;

public class Programmers88 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int index = 0;

        for (int i = people.length - 1; i > index; i--) {
            if (people[i] + people[index] <= limit) {
                answer++;
                index++;
            } else {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers88 test = new Programmers88();
        System.out.println(test.solution(new int[]{70, 50, 80, 50}, 100));
    }
}

