import java.util.*;

class Programmers_괄호회전하기 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            s = s.substring(1) + s.charAt(0);
            if (check(s)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}') {
                    return false;
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                if ((stack.peek() == '[' && s.charAt(i) == ']')
                        || (stack.peek() == '(' && s.charAt(i) == ')')
                        || (stack.peek() == '{' && s.charAt(i) == '}')) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
    }
}

