import java.util.Arrays;
import java.util.Map;

public class Programmers04 {
    public int[] solution(String[] wallpaper) {

        int minY = 100;
        int minX = 100;
        int maxY = -1;
        int maxX = -1;


        for (int x = 0; x < wallpaper.length; x++) {
            for (int y = 0; y < wallpaper[x].length(); y++) {
                if (wallpaper[x].charAt(y) == '#') {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }


    public static void main(String[] args) {
        Programmers04 test = new Programmers04();
        System.out.println(Arrays.toString(test.solution((new String[]{".#...", "..#..", "...#."}))));
        System.out.println(Arrays.toString(test.solution((new String[]{"....#", "..#..", "...#."}))));


    }
}
