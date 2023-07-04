import java.util.*;

public class Programmers85 {
    public int solution(String dirs) {
        int answer = 0;
        List<int[]> start = new ArrayList<>();
        List<int[]> end = new ArrayList<>();

        int x = 5;
        int y = 5;
        int nx = 0;
        int ny = 0;

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                nx = x - 1;
                ny = y;
            } else if (dirs.charAt(i) == 'D') {
                nx = x + 1;
                ny = y;
            } else if (dirs.charAt(i) == 'L') {
                nx = x;
                ny = y - 1;
            } else if (dirs.charAt(i) == 'R') {
                nx = x;
                ny = y + 1;
            }

            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) {
                continue;
            }

            boolean check = true;
            for (int k = 0; k < start.size(); k++) {
                if (start.get(k)[0] == x && start.get(k)[1] == y && end.get(k)[0] == nx && end.get(k)[1] == ny) {
                    check = false;
                    break;
                } else if (start.get(k)[0] == nx && start.get(k)[1] == ny && end.get(k)[0] == x && end.get(k)[1] == y) {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer++;
                start.add(new int[]{x, y});
                end.add(new int[]{nx, ny});
            }
            x = nx;
            y = ny;
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers85 test = new Programmers85();
        System.out.println(test.solution("ULURRDLLU"));

    }
}
