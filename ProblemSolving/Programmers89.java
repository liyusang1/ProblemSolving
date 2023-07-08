import java.util.Arrays;

public class Programmers89 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder("");
        int start = 0;
        int last = k;

        for(int i=0; i<number.length() - k; i++) {
            char max = 0;
            int max_idx = 0;
            for(int j=start; j<=last; j++)
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    max_idx = j;
                }

            sb.append(max);
            start = max_idx+1;
            last++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Programmers89 test = new Programmers89();
        //System.out.println(test.solution("1924", 2));
        //System.out.println(test.solution("1231234", 3));
        System.out.println(test.solution("4177252841", 4)); //775841

    }
}

