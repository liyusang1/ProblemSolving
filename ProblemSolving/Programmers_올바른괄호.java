import java.util.*;

public class Programmers_올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (s.charAt(i) == ')') {
                    return false;
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                // if ( stack.peek() == '(' )  시간초과 후 수정, 이 조건검사는 없어도 된다고 생각. 위 if문에서 stack이 비었을 때
                // ')'가 들어오면 false를 리턴하기에 stack의 peek가 '('인 조건을 검사할 필요가 없음
                if (s.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Programmers_올바른괄호 test = new Programmers_올바른괄호();
        System.out.println(test.solution("()()"));
        System.out.println(test.solution("(())()"));
        System.out.println(test.solution("(()("));
    }
}

