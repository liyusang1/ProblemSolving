import java.util.*;

public class Programmers_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportCount = new HashMap<>(); //신고당한 유저들을 저장하기 위한 map
        Set<String> reportList = new HashSet<>(Arrays.asList(report)); //set으로 변경하여 중복제거

        for (String i : reportList) { //for문을 돌며 신고당한 유저들을 map에 기록
            String[] temp = i.split(" ");
            reportCount.put(temp[1], reportCount.getOrDefault(temp[1], 0) + 1);
        }

        Map<String, Integer> mailCount = new HashMap<>(); //메일을 보내기 위한 유저들을 저장하기 위한 리포트를 카운트 하는 map

        for (String i : reportList) { //for문을 다시 돌면 k번 이상 신고당한 유저들을 신고한 유저들을 map에 카운트
            String[] temp = i.split(" ");
            if (reportCount.get(temp[1]) >= k) { // for문을 돌면서 현재 사람이 신고한 사람이 몇번 신고 되었는지 if로 체크함,k번 이상 신고했으면 추가해줌
                mailCount.put(temp[0], mailCount.getOrDefault(temp[0], 0) + 1);
            }
        }

        for (int i = 0; i < answer.length; i++) { //2번째 맵에 기록된 것들을 배열에 넣어주면 됨
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_신고결과받기 test = new Programmers_신고결과받기();
        System.out.println(Arrays.toString(test.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
    }
}

