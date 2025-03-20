public class Programmers_유연근무제 {
    public static void main(String[] args) {

        Programmers_유연근무제 p = new Programmers_유연근무제();
        p.solution(new int[]{700, 800, 1100},
                new int[][]{
                        {710, 2359, 1050, 700, 650, 631, 659},
                        {800, 801, 805, 800, 759, 810, 809},
                        {1105, 1001, 1002, 600, 1059, 1001, 1100}},
                5
        );

        p.solution(new int[]{730, 855, 700, 720},
                new int[][]{
                        {710, 700, 650, 735, 700, 931, 912},
                        {908, 901, 805, 815, 800, 831, 835},
                        {705, 701, 702, 705, 710, 710, 711},
                        {707, 731, 859, 913, 934, 931, 905}
                },
                1
        );

        p.solution(new int[]{750, 855},
                new int[][]{
                        {820, 800, 650, 735, 700, 700, 712},
                        {908, 901, 805, 815, 800, 831, 835},
                },
                7
        );
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean check = true;
        int defaultStartday = startday;

        for (int i = 0; i < schedules.length; i++) {
            startday = defaultStartday;
            check = true;
            for (int j = 0; j < timelogs[i].length; j++) {
                if (startday == 8) {
                    startday = 1;
                }

                if (startday == 6 || startday == 7) {
                    startday++;
                    continue;
                }

                //주의 반려케이스 : 10분을 더했을때 정각이 되는 경우를 고려해야함 -> 배열의 값을 바꿔줌
                if (((schedules[i] / 100) * 60 + (schedules[i] % 100))
                        - ((timelogs[i][j] / 100) * 60 + timelogs[i][j] % 100) < -10) {
                    check = false;
                    break;
                }
                startday++;
            }

            if (check) {
                answer++;
            }
        }

        return answer;
    }
}
