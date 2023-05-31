public class Programmers22 {

    public int solution(int[][] sizes) {

        int maxX = -1;
        int maxY = -1;

        for (int[] i : sizes) {
            int x = 0;
            int y = 0;
            if (i[0] < i[1]) {
                x = i[1];
                y = i[0];
            } else {
                x = i[0];
                y = i[1];
            }

            if (x > maxX) {
                maxX = x;
            }
            if (y > maxY) {
                maxY = y;
            }
        }

        return maxX*maxY;
    }


    public static void main(String[] args) {

        Programmers22 test = new Programmers22();
        System.out.println(test.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}
        ));

    }
}
