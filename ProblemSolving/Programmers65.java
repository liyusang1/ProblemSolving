import java.util.*;

public class Programmers65 {
    public int solution(String[][] book_time) {

        int[][] timeList = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            String[] temp = book_time[i][0].split(":");
            timeList[i][0] = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);

            String[] temp2 = book_time[i][1].split(":");
            timeList[i][1] = Integer.parseInt(temp2[0]) * 60 + Integer.parseInt(temp2[1]);
        }

        Arrays.sort(timeList, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < timeList.length; i++) {
            if (priorityQueue.isEmpty()) {
                priorityQueue.add(timeList[i][1]);
            } else if (priorityQueue.peek() + 10 > timeList[i][0]) {
                priorityQueue.add(timeList[i][1]);
            } else if (priorityQueue.peek() + 10 <= timeList[i][0]) {
                priorityQueue.remove();
                priorityQueue.add(timeList[i][1]);
            }
        }

        return priorityQueue.size();
    }

    public static void main(String[] args) {

        Programmers65 test = new Programmers65();
        System.out.println(test.solution(new String[][]{
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"},
        }));

        System.out.println(test.solution(new String[][]{
                {"09:10", "10:10"}, {"10:20", "12:20"}
        }));

        System.out.println(test.solution(new String[][]{
                {"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}
        }));
    }
}
