import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ8979 {
    public static void main(String[] args) throws IOException {

        // BufferedReader 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 첫번째 라인 값 3 입력
        int len = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        ArrayList<Madel> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int order = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new Madel(order, x, y, z));
        }

        Collections.sort(list);

        int rank = 1;
        int temp = 1;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).order == target) {
                System.out.println(rank);
                //System.out.println(list.get(i).order + " " + list.get(i).x + " " + list.get(i).y + " " + list.get(i).z);
            }

            if (i + 1 < list.size()) {
                if (list.get(i).x == list.get(i + 1).x
                        && list.get(i).y == list.get(i + 1).y
                        && list.get(i).z == list.get(i + 1).z) {
                    temp++;
                } else {
                    rank += temp;
                    temp = 1;
                }
            }
        }
    }

    static class Madel implements Comparable<Madel> {
        int order;
        int x;
        int y;
        int z;

        Madel(int order, int x, int y, int z) {
            this.order = order;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Madel o) {
            int compareX = Integer.compare(o.x, this.x);
            if (compareX != 0) {
                return compareX;
            }

            int compareY = Integer.compare(o.y, this.y);
            if (compareY != 0) {
                return compareY;
            }

            return Integer.compare(o.z, this.z);
        }

    }
}
