
public class Programmers_점찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        for (long x = 0; x <= d; x += k) {

            //원의 중심이 a,b 반지름이 r인 원의 방정식 (x-a)^2 + (y-b)^2  = r^2
            //중심이 0,0이기때문에 x^2+y^2 = r^2
            // y^2 = r^2 - x^2 , 반지름이 d이하인 값을 구해야함
            double y = Math.sqrt(((long) d * d) - ((long) x * x));
            answer += Math.ceil(y / k); //y값을 찾았으니 k로 나눠준 값을 더하면됨
            if (y % k == 0)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_점찍기 test = new Programmers_점찍기();
        System.out.println(test.solution(2, 4));
    }
}

