import java.util.Arrays;

public class PCCE_공원 {
    public static void main(String[] args) {

        PCCE_공원 sol = new PCCE_공원();
        System.out.println(sol.solution(new int[]{5, 3, 2},
                new String[][]{
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
                }));

        System.out.println(sol.solution(new int[]{1},
                new String[][]{
                        {"A"},
                }));

        System.out.println(sol.solution(new int[]{1},
                new String[][]{
                        {"A", "-1"},
                }));

        System.out.println(sol.solution(new int[]{3, 2, 15, 1},
                new String[][]{
                        {"A", "-1", "-1"},
                        {"-1", "-1", "-1"},
                        {"-1", "-1", "-1"},
                        {"-1", "-1", "-1"}
                }));
    }

    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int answer = -1;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")) {
                    for (int k = mats.length - 1; k >= 0; k--) {
                        if (isAvailable(mats[k], park, i, j)) {
                            answer = Math.max(answer, mats[k]);
                        }
                    }
                }
            }
        }

        return answer;
    }

    public boolean isAvailable(int mats, String[][] park, int x, int y) {
        for (int i = x; i < x + mats; i++) {
            for (int j = y; j < y + mats; j++) {
                if (i >= park.length || j >= park[i].length) {
                    return false;
                } else if (!park[i][j].equals("-1")) {
                    return false;
                }

            }
        }

        return true;
    }
}
