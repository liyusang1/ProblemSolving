import java.util.ArrayList;
import java.util.HashSet;

public class Programmers_후보키 {
    public int solution(String[][] relation) {
        int columnLength = relation[0].length;
        int rowLength = relation.length;
        ArrayList<Integer> answers = new ArrayList<Integer>();

        // 모든 부분집합의 경우의 수 구하기
        for (int i = 0; i < (1 << columnLength); i++) {
            int m = 1;
            String checkcolNums = "";
            for (int j = 0; j < columnLength; j++) {
                if ((i & m) > 0) {
                    checkcolNums += (j + 1) + "";
                }
                m = m << 1;
            }
            if (checkcolNums.equals(0)) continue;
            //중복이 있는지 확인...
            int temp = checkUniqueness(checkcolNums, relation);
            // 중복이 없고 && 최소성을 체크한다
            if (temp == rowLength && checkMinimality(answers, i)) answers.add(i);
        }
        return answers.size();
    }

    private static boolean checkMinimality(ArrayList<Integer> answers, int now) {
        for (int i = 0; i < answers.size(); i++)
            if ((answers.get(i) & now) == answers.get(i)) return false;
        return true;
    }

    private static int checkUniqueness(String checkcolNums, String[][] relation) {

        int colsize = checkcolNums.length();
        HashSet<String> hashSet = new HashSet<String>();

        for (int i = 0; i < relation.length; i++) {
            StringBuffer str = new StringBuffer();
            for (int j = 0; j < colsize; j++) {
                String[] checkcol = checkcolNums.split("");
                int col = Integer.parseInt(checkcol[j]);
                str.append(relation[i][col - 1]);
            }
            hashSet.add(str.toString());
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        Programmers_후보키 test = new Programmers_후보키();
        System.out.println(test.solution(new String[][]{
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        }));
    }
}

