import java.util.*;

public class BOJ9017 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            int[] rank = new int[count];
            Map<Integer, Integer> result = new HashMap<>();
            for (int j = 0; j < count; j++) {
                int data = scanner.nextInt();
                result.put(data, result.getOrDefault(data, 0) + 1);
                rank[j] = data;
            }

            int[] fiveGoal = new int[result.size() + 1];
            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> tempMap = new HashMap<>();
            int score = 1;

            for (int element : rank) {
                if (result.get(element) >= 6) {
                    tempMap.put(element, tempMap.getOrDefault(element, 0) + 1);

                    if (tempMap.get(element) <= 4) {
                        scoreMap.put(element, scoreMap.getOrDefault(element, 0) + score);
                    }

                    if (tempMap.get(element) == 5) {
                        fiveGoal[element] = score;
                    }
                    score++;
                }
            }

            List<Integer> keyData = new ArrayList<>(scoreMap.keySet());
            keyData.sort((x, y) -> {
                if (Objects.equals(scoreMap.get(x), scoreMap.get(y))) {
                    return fiveGoal[x] - fiveGoal[y];
                } else {
                    return scoreMap.get(x) - scoreMap.get(y);
                }
            });
            System.out.println(keyData.get(0));
        }
    }
}
