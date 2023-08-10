import java.util.*;

public class Programmers_과제진행하기 {
    class Homework {
        String name;
        int start, playtime;

        public Homework(String name, String start, String playtime) {
            this.name = name;
            this.start = parseTime(start);
            this.playtime = Integer.parseInt(playtime);
        }

        private int parseTime(String time) {
            String[] t = time.split(":");
            return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
    }

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Queue<Homework> remain = new PriorityQueue<>();
        Deque<Homework> task = new ArrayDeque<>();
        for (String[] plan : plans) {
            remain.offer(new Homework(plan[0], plan[1], plan[2]));
        }
        int curTime = remain.peek().start;
        task.add(remain.poll());
        while (!remain.isEmpty()) {
            Homework next;
            if (remain.peek().start < curTime + task.peekLast().playtime) {
                // 새 과제 시작전에 진행중인 작업을 끝내지 못함
                next = remain.poll();
                task.peekLast().playtime -= next.start - curTime;
                curTime = next.start;
                task.add(next);
            } else {
                // 진행중인 작업 끝
                curTime += task.peekLast().playtime;
                answer.add(task.pollLast().name);
            }
            if (task.isEmpty()) {
                curTime = remain.peek().start;
                task.add(remain.poll());
            }
        }
        while (!task.isEmpty()) {
            answer.add(task.pollLast().name);
        }
        return answer.toArray(new String[answer.size()]);
    }

    public static void main(String[] args) {
        Programmers_과제진행하기 test = new Programmers_과제진행하기();
        System.out.println(Arrays.toString(test.solution(new String[][]{
                        {"korean", "11:40", "30"},
                        {"english", "12:10", "20"},
                        {"math", "12:30", "40"}
                }
        )));
    }
}

