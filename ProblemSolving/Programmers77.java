public class Programmers77 {
    int answer = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];
        DFS(k, 0, dungeons, visited);
        return answer;
    }

    public void DFS(int k, int depth, int[][] dungeons, boolean[] visited) {
        for (int i = 0; i < dungeons.length; i++) {

            if (visited[i] == false && dungeons[i][0] <= k) {
                visited[i] = true;
                DFS(k - dungeons[i][1], depth + 1, dungeons, visited);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }

    public static void main(String[] args) {

        Programmers77 test = new Programmers77();
        System.out.println(test.solution(80, new int[][]{
                {80, 20},
                {50, 40},
                {30, 10}
        }));

        System.out.println(test.solution(100, new int[][]{
                {100, 1},
                {70, 10},
                {60, 30},
                {80, 10}
        }));
    }
}
