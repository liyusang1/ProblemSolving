public class Programmers45 {
    public int solution(int n) {
        int answer = 0;

        String[] arr = String.valueOf(n).split("");
        for (String i : arr) {
            answer += Integer.parseInt(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        Programmers45 test = new Programmers45();
        System.out.println(test.solution(6));
        System.out.println(test.solution(16));
        System.out.println(test.solution(626331));
    }
}
