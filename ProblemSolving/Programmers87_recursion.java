public class Programmers87_recursion {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }

    public void dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            dfs(depth + 1, numbers, target, sum + numbers[depth]);
            dfs(depth + 1, numbers, target, sum - numbers[depth]);
        }
    }

    public static void main(String[] args) {

        Programmers87_recursion test = new Programmers87_recursion();
        System.out.println(test.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

