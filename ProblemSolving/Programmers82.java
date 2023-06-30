import java.util.*;

public class Programmers82 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(0);
            s = s.substring(1);
            s = s + temp;

            Stack<String> stack = new Stack();
            String[] arr = s.split("");
            boolean check = true;

            for (String string : arr) {
                if (stack.isEmpty()) {
                    if (string.equals("]") || string.equals(")") || string.equals("}")) {
                        check = false;
                        break;
                    } else {
                        stack.push(string);
                    }
                } else {
                    if ((stack.peek().equals("[") && string.equals("]")) || (stack.peek().equals("{") && string.equals("}"))
                            || (stack.peek().equals("(") && string.equals(")"))) {
                        stack.pop();
                    } else if (string.equals("}") || string.equals("]") || string.equals(")")) {
                        check = false;
                        break;
                    } else {
                        stack.push(string);
                    }
                }
            }

            if (check && stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers82 test = new Programmers82();
        System.out.println(test.solution("[](){}"));
        System.out.println(test.solution("()("));
        System.out.println(test.solution("("));
        System.out.println(test.solution("{{{{{{"));
    }
}
