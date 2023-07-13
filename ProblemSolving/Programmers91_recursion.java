import java.util.*;

public class Programmers91_recursion {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        recur(numbers, set, "", visited);

        for (Integer i : set) {
            if (isPrime(i) == true) {
                answer++;
            }
        }

        return answer;
    }

    public void recur(String numbers, Set set, String temp, boolean[] visited) {

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;

            set.add(Integer.parseInt(temp + numbers.charAt(i)));
            recur(numbers, set, temp + numbers.charAt(i), visited);
            visited[i] = false;
        }
    }

    public boolean isPrime(int n) {
        int count = 0;

        if (n == 2) {
            return true;
        } else if (n == 1 || n == 0) {
            return false;
        }

        for (int i = 1; i < Math.sqrt(n) + 1; i++) {
            if (count > 2) {
                return false;
            }

            if (n % i == 0) {
                if (i != n / i) {
                    count += 2;
                } else {
                    count++;
                }
            }
        }

        if (count != 2) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {

        Programmers91_recursion test = new Programmers91_recursion();
        System.out.println(test.solution("123"));
        System.out.println(test.solution("17"));
        System.out.println(test.solution("011"));

    }
}

