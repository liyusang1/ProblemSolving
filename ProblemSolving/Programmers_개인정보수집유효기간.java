import java.util.*;

public class Programmers_개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        String[] arr1 = today.split("\\."); // .은 split을 할때 정규표현식 때문에 \\를 사용해서 split을 해야함
        int todayCount = (Integer.parseInt(arr1[0]) * 28 * 12) + (Integer.parseInt(arr1[1]) * 28) + (Integer.parseInt(arr1[2])); //오늘날짜를 하나의 숫자로 치환

        Map<String, Integer> term = new HashMap<>(); //map을 사용해서 각각의 알파벳의 유효기간을 저장
        for (String i : terms) {
            String[] temp = i.split(" ");
            term.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] temp1 = privacies[i].split(" ");
            String[] temp2 = temp1[0].split("\\.");
            int nowCount = (Integer.parseInt(temp2[0]) * 28 * 12) + (Integer.parseInt(temp2[1]) * 28) + (Integer.parseInt(temp2[2]));
            nowCount += term.get(temp1[1]);

            if (todayCount >= nowCount) { //오늘날짜보다 지났으면 정답리스트에 추가
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    public static void main(String[] args) {
        Programmers_개인정보수집유효기간 test = new Programmers_개인정보수집유효기간();

        System.out.println(Arrays.toString(test.solution("2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));

        System.out.println(Arrays.toString(test.solution("2020.01.01",
                new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }
}

