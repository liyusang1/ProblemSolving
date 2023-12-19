import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Deque queue = new ArrayDeque();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.removeFirst();
            queue.addLast(queue.removeFirst());
        }

        System.out.println(queue.getFirst());
    }
}
