package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO start를 0으로 초기화 해주고 나중에 값을 1를 빼지 않도록 구성하면 시간초과 발생 -> visited의 값이 0이여서 다시 탐색해서 시간초과발생하는듯...

public class BOJ13549 {
    static class Location {
        int x;
        int time;

        public Location(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(start, 1));
        visited[start] = 1;

        while (!queue.isEmpty()) {
            Location loc = queue.poll();

            //+1
            if (loc.x + 1 >= 0 && loc.x + 1 < 100001) {
                if (visited[loc.x + 1] == 0 || visited[loc.x + 1] > loc.time + 1) {
                    visited[loc.x + 1] = loc.time + 1;
                    queue.add(new Location(loc.x + 1, loc.time + 1));
                }
            }

            //-1
            if (loc.x - 1 >= 0 && loc.x - 1 < 100001) {
                if (visited[loc.x - 1] == 0 || visited[loc.x - 1] > loc.time + 1) {
                    visited[loc.x - 1] = loc.time + 1;
                    queue.add(new Location(loc.x - 1, loc.time + 1));
                }
            }

            //*2
            if (loc.x * 2 >= 0 && loc.x * 2 < 100001) {
                if (visited[loc.x * 2] == 0 || visited[loc.x * 2] > loc.time) {
                    visited[loc.x * 2] = loc.time;
                    queue.add(new Location(loc.x * 2, loc.time));
                }
            }
        }

        System.out.println(visited[target]-1);
    }
}

