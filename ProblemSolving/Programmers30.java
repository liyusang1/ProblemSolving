public class Programmers30 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int[] left = {3, 0};
        int[] right = {3, 2};

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                sb.append("L");

                switch (i) {
                    case 1:
                        left[0] = 0;
                        left[1] = 0;
                        break;
                    case 4:
                        left[0] = 1;
                        left[1] = 0;
                        break;
                    default:
                        left[0] = 2;
                        left[1] = 0;
                }
            } else if (i == 3 || i == 6 || i == 9) {
                sb.append("R");

                switch (i) {
                    case 3:
                        right[0] = 0;
                        right[1] = 2;
                        break;
                    case 6:
                        right[0] = 1;
                        right[1] = 2;
                        break;
                    default:
                        right[0] = 2;
                        right[1] = 2;
                }
            } else {
                int nowX = 0;
                int nowY = 1;

                if (i == 2) {
                    nowX = 0;
                } else if (i == 5) {
                    nowX = 1;
                } else if (i == 8) {
                    nowX = 2;
                } else if (i == 0) {
                    nowX = 3;
                }

                int leftCount = Math.abs(left[0] - nowX) + Math.abs(left[1] - nowY);
                int rightCount = Math.abs(right[0] - nowX) + Math.abs(right[1] - nowY);

                if (leftCount < rightCount) {
                    sb.append("L");
                    left[0] = nowX;
                    left[1] = nowY;
                } else if (leftCount > rightCount) {
                    sb.append("R");
                    right[0] = nowX;
                    right[1] = nowY;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right[0] = nowX;
                        right[1] = nowY;
                    } else {
                        sb.append("L");
                        left[0] = nowX;
                        left[1] = nowY;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Programmers30 test = new Programmers30();

        System.out.println(test.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));

    }
}
