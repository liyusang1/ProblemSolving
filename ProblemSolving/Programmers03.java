import java.util.Arrays;

public class Programmers03 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int xMax = park.length;
        int yMax = park[0].length();

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        for (String i : routes) {
            int number = Integer.parseInt(String.valueOf(i.charAt(2)));
            boolean check = true;

            if (i.charAt(0) == 'N') {
                if (answer[0] - number < 0) {
                    continue;
                }
                for (int j = 1; j <= number; j++) {
                    if (park[answer[0] - j].charAt(answer[1]) == 'X') {
                        check = false;
                        break;
                    }
                }
                if (check==true) {
                    answer[0] -= number;
                }

            } else if (i.charAt(0) == 'S') {
                if (answer[0] + number >= xMax) {
                    continue;
                }
                for (int j = 1; j <= number; j++) {
                    if (park[answer[0] + j].charAt(answer[1]) == 'X') {
                        check = false;
                        break;
                    }
                }
                if (check==true) {
                    answer[0] += number;
                }
            } else if (i.charAt(0) == 'E') {
                if (answer[1] + number >= yMax) {
                    continue;
                }
                for (int j = 1; j <= number; j++) {
                    if (park[answer[0]].charAt(answer[1] + j) == 'X') {
                        check = false;
                        break;
                    }
                }
                if (check==true) {
                    answer[1] += number;
                }
            } else if (i.charAt(0) == 'W') {
                if (answer[1] - number < 0) {
                    continue;
                }
                for (int j = 1; j <= number; j++) {
                    if (park[answer[0]].charAt(answer[1] - j) == 'X') {
                        check = false;
                        break;
                    }
                }
                if (check==true) {
                    answer[1] -= number;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers03 test = new Programmers03();


        System.out.println(Arrays.toString(test.solution(
                new String[]{"SOO", "OOO", "OOO"},
                new String[]{"E 2", "S 2", "W 1"}
        )));


        System.out.println(Arrays.toString(test.solution(
                new String[]{"SOO", "OXX", "OOO"},
                new String[]{"E 2", "S 2", "W 1"}
        )));


        System.out.println(Arrays.toString(test.solution(
                new String[]{"OSO", "OOO", "OXO", "OOO"},
                new String[]{"E 2", "S 3", "W 1"}
        )));
    }
}

