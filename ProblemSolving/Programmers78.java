import java.util.*;

public class Programmers78 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {

            List[] graph = new List[n + 1];
            for (int t = 0; t < n + 1; t++) {
                graph[t] = new ArrayList();
            }

            for (int k = 0; k < wires.length; k++) {
                if (i == k) {
                    continue;
                }
                graph[wires[k][0]].add(wires[k][1]);
                graph[wires[k][1]].add(wires[k][0]);
            }

            int a;
            int b=-1;
            boolean [] visited = new boolean[n+1];
            a = DFS(i+1,visited,graph);

            for(int g = 1; g<n+1; g++){
                b = Math.max(b,DFS(g,visited,graph));
            }

            answer = Math.min(Math.abs(a-b),answer);
        }
        return answer;
    }

    public int DFS(int start,boolean [] visited,List [] graph){
        int depth = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            for(Object i : graph[temp]){
                if(visited[(int) i]==false){
                    visited[(int)i] = true;
                    q.add((int)i);
                    depth++;
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {

        Programmers78 test = new Programmers78();
        System.out.println(test.solution(9,
                new int[][]{
                        {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
                }));

        System.out.println(test.solution(4,
                new int[][]{
                        {1, 2}, {2, 3}, {3, 4},{2,4}
                }));
    }
}
