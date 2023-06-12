import java.util.*;

class Task {
    String name;
    int time;
    int duration;

    public Task(String name, String time, String duration) {
        this.name = name;
        String[] temp = time.split(":");
        this.time = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        this.duration = Integer.parseInt(duration);
    }

    public void get() {
        System.out.println(this.name + " : " + this.time + " : " + this.duration);
    }
}

public class Programmers60 {

    public List solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<Task> tasks = new ArrayDeque<>();
        Stack<Task> stopped = new Stack<>();

        Arrays.sort(plans, Comparator.comparingInt(o -> Integer.parseInt(o[1].split(":")[0]) * 60
                + Integer.parseInt(o[1].split(":")[1])));

        for (int i = 0; i < plans.length; i++) {
            tasks.addLast(new Task(plans[i][0], plans[i][1], plans[i][2]));
        }

        int currentTime = 0;
        while (!tasks.isEmpty() || !stopped.isEmpty()) {

            if (stopped.isEmpty()) {
                currentTime = tasks.getFirst().time;
                stopped.push(tasks.removeFirst());
            } else if (tasks.isEmpty()) {
                answer.add((stopped.peek()).name);
                stopped.pop();
            } else {
                if (currentTime + stopped.peek().duration <= tasks.getFirst().time) {
                    currentTime += stopped.peek().duration;
                    answer.add(stopped.peek().name);
                    stopped.pop();
                } else {
                    stopped.peek().duration -= tasks.getFirst().time - stopped.peek().time;
                    stopped.push(tasks.removeFirst());
                    currentTime = stopped.peek().time;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers60 test = new Programmers60();

        System.out.println((test.solution(new String[][]{{"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}})));

        System.out.println((test.solution(new String[][]{{"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}})));

        System.out.println((test.solution(new String[][]{{"science", "12:40", "10"},
                {"music", "12:50", "10"},
                {"history", "13:00", "10"},
                {"computer", "13:10", "10"}})));

        System.out.println((test.solution(new String[][]{{"A", "12:00", "30"},
                {"B", "12:10", "20"},
                {"C", "15:00", "40"},
                {"D", "15:10", "30"}})));

        System.out.println((test.solution(new String[][]{{"1", "00:00", "30"},
                {"2", "00:10", "10"},
                {"3", "00:30", "10"},
                {"4", "00:50", "10"}
        })));

        System.out.println((test.solution(new String[][]{{"1", "00:00", "30"},
                {"2", "00:10", "30"},
                {"3", "00:20", "30"},
                {"4", "24:50", "1000"}
        })));
    }
}
