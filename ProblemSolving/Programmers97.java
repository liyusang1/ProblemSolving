import java.util.*;
//프로그래머스 의상
public class Programmers97 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] i : clothes) {
            map.put(i[1], map.getOrDefault(i[1], 0) + 1);
        }

        int answer = clothes.length;

        if (map.size() > 1) {

            int count = 1;
            for (String key : map.keySet()) {
                count *= map.get(key) + 1;
            }
            answer = count - 1;
        }

        return answer;
    }


    public static void main(String[] args) {

        Programmers97 test = new Programmers97();
        System.out.println(test.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));
    }
}

