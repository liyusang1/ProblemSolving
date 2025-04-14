package _0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ3758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); //팀의 수
            int k = Integer.parseInt(st.nextToken()); //문제 개수
            int myteam = Integer.parseInt(st.nextToken()); //나의팀 번호
            int m = Integer.parseInt(st.nextToken()); //전체개수

            Team[] teams = new Team[n];
            for (int j = 0; j < n; j++) {
                teams[j] = new Team(j + 1);
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int teamId = Integer.parseInt(st.nextToken()); //팀id
                int quizId = Integer.parseInt(st.nextToken()); //문제 번호
                int score = Integer.parseInt(st.nextToken()); //점수

                teams[teamId - 1].updateMap(quizId, score, j);
            }

            Arrays.sort(teams);

            for (int j = 0; j < teams.length; j++) {
                if (teams[j].teamNumber == myteam) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        for (int j = 0; j < answer.length; j++) {
            System.out.println(answer[j]);
        }
    }

    static class Team implements Comparable<Team> {
        int count = 0;
        Map<Integer, Integer> map;
        int totalScore = 0;
        int teamNumber;
        int lastTime = 0;

        Team(int teamNumber) {
            this.teamNumber = teamNumber;
            this.map = new HashMap<Integer, Integer>();
        }

        void updateMap(int quizNum, int score, int time) {
            if (map.containsKey(quizNum)) {
                if (map.get(quizNum) < score) {
                    totalScore -= map.get(quizNum);
                    map.put(quizNum, score);
                    totalScore += score;
                }
            } else {
                map.put(quizNum, score);
                totalScore += score;
            }
            this.lastTime = time; //그냥 마지막 시간 무조건 갱신, 최고점수가 아니여도
            count++;
        }

        @Override
        public int compareTo(Team o) {
            int compare1 = Integer.compare(o.totalScore, this.totalScore);
            if (compare1 != 0) {
                return compare1;
            }
            int compare2 = Integer.compare(this.count, o.count);
            if (compare2 != 0) {
                return compare2;
            }

            return Integer.compare(this.lastTime, o.lastTime);
        }
    }
}

/*
1
3 4 3 5
2 1 30
2 3 30
1 1 30
1 3 30
3 1 20

1
3 4 3 5
1 1 30
2 3 30
1 2 40
1 2 20
3 1 70


1
2 2 2 2
1 1 30
2 1 30

1
4 2 3 5
1 1 30
2 1 50
3 2 60
1 2 20
1 1 100

1
4 2 3 4
1 1 30
2 2 30
3 3 30

*/
