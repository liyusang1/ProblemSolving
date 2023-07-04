import java.util.ArrayList;
import java.util.List;

public class Programmers86 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {

            int index = 0;
            boolean check = true;
            for (int i = 0; i < skill_tree.length(); i++) {
                if (!check) {
                    break;
                }

                for (int j = 0; j < skill.length(); j++) {
                    if (skill_tree.charAt(i) == skill.charAt(j)) {
                        if (j == index) {
                            index++;
                        } else {
                            check = false;
                        }
                        break;
                    }
                }
            }

            if (check) {
                answer++;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {

        Programmers86 test = new Programmers86();
        System.out.println(test.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}

