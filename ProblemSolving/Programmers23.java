public class Programmers23 {

    public long solution(int price, int money, int count) {
        long temp = 0;

        for (int i = 1; i <= count; i++) {
            temp += i * price;
        }

        if (money - temp >= 0) {
            return 0;
        }
        
        return temp - money;
    }


    public static void main(String[] args) {

        Programmers23 test = new Programmers23();
        System.out.println(test.solution(3, 20, 4));
    }
}
