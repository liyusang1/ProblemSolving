import java.util.*;

public class Programmers54 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < survey.length; i++) {

            String[] temp = survey[i].split("");
            switch (choices[i]) {
                case 1:
                    map.put(temp[0], map.get(temp[0]) + 3);
                    break;
                case 2:
                    map.put(temp[0], map.get(temp[0]) + 2);
                    break;
                case 3:
                    map.put(temp[0], map.get(temp[0]) + 1);
                    break;
                case 5:
                    map.put(temp[1], map.get(temp[1]) + 1);
                    break;
                case 6:
                    map.put(temp[1], map.get(temp[1]) + 2);
                    break;
                case 7:
                    map.put(temp[1], map.get(temp[1]) + 3);
                    break;
            }
        }

        String[] x = new String[]{"R", "C", "J", "A" };
        String[] y = new String[]{"T", "F", "M", "N" };

        for (int i = 0; i < x.length; i++) {

            int a = map.get(x[i]);
            int b = map.get(y[i]);

            if (a > b) {
                answer += x[i];
            } else if (a < b) {
                answer += y[i];
            } else {
                answer += x[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Programmers54 test = new Programmers54();
        System.out.println(test.solution(new String[]{"AN", "CF", "MJ", "RT", "NA" }, new int[]{5, 3, 2, 7, 5}));
    }
}
