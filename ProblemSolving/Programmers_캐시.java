import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_캐시 {
    public int solution(int cacheSize, String[] cities) {
        //캐시 교체 알고리즘은 LRU(Least Recently Used)를 알고 있어야함
        //캐시 queue를 만들어두고, 캐시 사이즈만큼 특정 값을 넣어두고 새로운 값이 들어올때마다 기존 캐시에 없다면 +5를 하고 queue에서 remove 하고 add해줌
        //있다면 +1

        int answer = 0;
        Queue<String> queue = new LinkedList<>(); //캐시로 사용할 큐
        int index = 0;

        //캐시에 캐시사이즈 만큼 도시들을 넣어두고 그 개수만큼 +5, 캐시 사이즈가 0이라면 그냥 바로 값 리턴
        if (cacheSize == 0) {
            return 5 * cities.length;
        } else {
            while (queue.size() < cacheSize) {
                if (index >= cities.length) { //11 16 19 20 반례에 걸림 -> 캐시사이즈가 city 길이보다 긴 경우를 고려해줘야함
                    return answer;
                }

                Iterator it = queue.iterator();

                boolean check = false;
                while (it.hasNext()) {
                    String temp = (String) it.next();
                    if (temp.equalsIgnoreCase(cities[index])) {
                        check = true;
                        queue.remove(temp);
                        queue.add(temp.toLowerCase());
                        break;
                    }
                }
                if (check) {
                    answer++;
                } else {
                    answer += 5;
                    queue.add(cities[index].toLowerCase());
                }
                index++;
            }
        }

        //기존 캐시에 도시가 있다면 +1, 없다면 remove후 add하는 로직, 이때 queue는 iterator를 통해 순회를 해야됨
        for (int i = cacheSize; i < cities.length; i++) {
            Iterator it = queue.iterator();
            boolean check = false;
            while (it.hasNext()) {
                String temp = (String) it.next();
                if (temp.equalsIgnoreCase(cities[i])) { //string 관련 메소드중 equalsIgnoreCase -> 대소문자들은 무시하고 글자만 비교가능
                    check = true;
                    queue.remove(temp);
                    queue.add(temp.toLowerCase());
                    break;
                }
            }
            if (check) {
                answer++;
            } else {
                answer += 5;
                queue.remove();
                queue.add(cities[i].toLowerCase());
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Programmers_캐시 test = new Programmers_캐시();
        /*System.out.println(test.solution(3,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(test.solution(5,
                new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));

        System.out.println(test.solution(5,
                new String[]{"leo", "leo", "leo"}));

        System.out.println(test.solution(5,
                new String[]{"a", "b", "c", "a"}));
*/
        System.out.println(test.solution(3,
                new String[]{"seoul", "seoul", "seoul", "tokyo", "seoul", "tokyo"}));

    }
}

