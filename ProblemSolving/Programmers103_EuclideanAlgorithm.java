//프로그래머스 n개의 최소 공배수
public class Programmers103_EuclideanAlgorithm {
    public int solution(int[] arr) {
        int answer = (arr[0] * arr[1]) / (getGcd(arr[0], arr[1]));

        for (int i = 2; i < arr.length; i++) {
            answer = (arr[i] * answer) / (getGcd(arr[i], answer));
        }

        return answer;
    }

    //Euclidean algorithm
    public int getGcd(int n1, int n2) {
        if (n1 < n2) {
            int temp;
            temp = n1;
            n1 = n2;
            n2 = temp;
        }

        if (n1 % n2 == 0) {
            return n2;
        } else {
            while (true) {
                int c = n1 % n2;
                if (c == 0) {
                    return n2;
                }
                n1 = n2;
                n2 = c;
            }
        }
    }

    public static void main(String[] args) {
        Programmers103_EuclideanAlgorithm test = new Programmers103_EuclideanAlgorithm();
        System.out.println(test.solution(new int[]{2, 6, 8, 14}));


    }
}

