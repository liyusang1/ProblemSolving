import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9017 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {

            int arrLen = Integer.parseInt(br.readLine());
            List<Team> teamList = new ArrayList<>();

            ArrayList<Integer>[] arrayLists = new ArrayList[arrLen + 1];
            for (int j = 0; j < arrLen + 1; j++) {
                arrayLists[j] = new ArrayList<>();
            }

            String[] splitArr = (br.readLine().split(" "));
            Map<String, Integer> check = new HashMap<>();
            for (int j = 0; j < splitArr.length; j++) {
                check.put((splitArr[j]), check.getOrDefault((splitArr[j]), 0) + 1);
            }

            int rank = 1;
            for (int j = 0; j < splitArr.length; j++) {
                if (check.containsKey((splitArr[j])) && check.get((splitArr[j])) >= 6) {
                    arrayLists[Integer.parseInt(splitArr[j])].add(rank++);
                }
            }

            for (int j = 1; j < arrayLists.length; j++) {
                if (arrayLists[j].size() < 6) {
                    continue;
                }
                int temp = 0;
                for (int k = 0; k < arrayLists[j].size() - 2; k++) {
                    temp += arrayLists[j].get(k);
                }
                teamList.add(new Team(j, temp, arrayLists[j].get(arrayLists[j].size() - 2)));
            }

            Collections.sort(teamList);
            answer[i] = teamList.get(0).order; //getFirst로 하면 제출시 에러
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }

    static class Team implements Comparable<Team> {
        int order;
        int score;
        int member5Score;

        Team(int order, int score, int member5Score) {
            this.order = order;
            this.score = score;
            this.member5Score = member5Score;
        }

        @Override
        public int compareTo(Team o) {

            int compare = Integer.compare(this.score, o.score);
            if (compare != 0) {
                return compare;
            }

            return Integer.compare(this.member5Score, o.member5Score);
        }
    }
}