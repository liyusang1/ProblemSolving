import java.util.ArrayList;
import java.util.List;

public class Programmers53 {
    public List solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        int todayCount = getDayCount(today);

        String[] terms1 = new String[terms.length];
        int[] terms2 = new int[terms.length];

        for (int i = 0; i < terms.length; i++) {
            String[] temp = terms[i].split(" ");
            terms1[i] = temp[0];
            terms2[i] = Integer.parseInt(temp[1]);
        }

        int k = 1;
        for (String i : privacies) {
            String[] temp1 = i.split(" ");

            //System.out.println(temp1[0]);
            //System.out.println(temp1[1]);

            int nowCount = getDayCount(temp1[0]);

            for (int j = 0; j < terms1.length; j++) {
                if (terms1[j].equals(temp1[1])) {
                    nowCount += terms2[j] * 28;
                }
            }

            //System.out.println(nowCount);
            //System.out.println(todayCount);
            //System.out.println("--");

            if (nowCount <= todayCount) {
                answer.add(k);
            }
            k++;
        }

        return answer;
    }

    public int getDayCount(String s) {

        String[] temp = s.split("\\.");
        int year = Integer.parseInt(temp[0].substring(1));
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
        return (year * 12 * 28) + month * 28 + day;
    }

    public static void main(String[] args) {

        Programmers53 test = new Programmers53();
        System.out.println(test.solution("2022.05.19",
                new String[]{"A 6", "B 12", "C 3" },
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" }));
    }
}
