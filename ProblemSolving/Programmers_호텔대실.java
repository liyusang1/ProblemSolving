import java.util.*;

public class Programmers_호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i[0])); //출입시간을 기준으로 우선순위큐에 저장
        for (String[] i : book_time) {
            String[] temp1 = i[0].split(":");
            String[] temp2 = i[1].split(":");
            priorityQueue.add(new int[]{Integer.parseInt(temp1[0]) * 60 + Integer.parseInt(temp1[1]), Integer.parseInt(temp2[0]) * 60 + Integer.parseInt(temp2[1])});
        }

        PriorityQueue<Integer> rooms = new PriorityQueue<>(); //퇴장시간만을 저장하는 우선순위큐
        rooms.add(priorityQueue.remove()[1]);
        answer++;

        while (!priorityQueue.isEmpty()) {
            int[] temp = priorityQueue.remove();
            if (rooms.peek() + 10 <= temp[0]) { //다음방의 종료시간이 다음예약의 시작시간보다 작거나 같다면 방을 더 추가할 필요가 없음
                rooms.remove();
                rooms.add(temp[1]); // 새로운 종료시간 기록
            } else {
                answer++;
                rooms.add(temp[1]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_호텔대실 test = new Programmers_호텔대실();
        System.out.println(test.solution(new String[][]{
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        }));
    }
}

