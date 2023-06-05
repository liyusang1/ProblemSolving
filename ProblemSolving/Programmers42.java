public class Programmers42 {
    public long solution(long n) {
        if (n % Math.sqrt(n) == 0) {
            return (long) ((Math.sqrt(n) + 1) * (Math.sqrt(n) + 1));
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Programmers42 test = new Programmers42();
        System.out.println(test.solution(6));
        System.out.println(test.solution(16));
        System.out.println(test.solution(626331));
    }
}
