import java.util.*;

public class Programmers21 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportCount = new HashMap<>();
        for (String i : id_list) {
            reportCount.put(i, 0);
        }

        Map<String, Integer> mailCount = new HashMap<>();
        for (String i : id_list) {
            mailCount.put(i, 0);
        }

        Set reports = new HashSet(Arrays.asList(report));

        Iterator<String> it = reports.iterator();
        while (it.hasNext()) {

            String[] strings = it.next().split(" ");
            reportCount.put(strings[1], reportCount.get(strings[1]) + 1);
        }

        Iterator<String> it2 = reports.iterator();
        while (it2.hasNext()) {

            String[] strings = it2.next().split(" ");

            if (reportCount.get(strings[1]) >= k) {
                mailCount.put(strings[0], mailCount.get(strings[0]) + 1);
            }
        }

        for (int i=0; i<id_list.length;i++){
            answer[i] = mailCount.get(id_list[i]);
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers21 test = new Programmers21();
        System.out.println(Arrays.toString(
                test.solution(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                        2))
        );

        System.out.println(Arrays.toString(
                test.solution(
                        new String[]{"con", "ryan"},
                        new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                        3))
        );

    }
}
