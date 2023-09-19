import java.util.*;

public class Programmers_우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();

        while(k > 1){
            list.add(k);

            if(k % 2 == 0){
                k /= 2;
            }else{
                k = k * 3 + 1;
            }
        }

        list.add(k);

        for(int i = 0; i < ranges.length; i++){

            //좌측x가 우측 x보다 큰경우 -1반환
            if(ranges[i][0] > ranges[i][1] + list.size() - 1){
                answer[i] = -1;
                continue;
            }else if(ranges[i][0] == ranges[i][1] + list.size() - 1){ //같으면 합이 0이됨
                answer[i] = 0;
                continue;
            }

            double dimension = 0;

            for(int j = ranges[i][0]; j < ranges[i][1] + list.size() - 1; j++){ //구간의 합
                dimension += (list.get(j) + list.get(j + 1)) / 2.0;
            }

            answer[i] = dimension;
        }

        return answer;
    }


    public static void main(String[] args) {
        Programmers_우박수열정적분 test = new Programmers_우박수열정적분();
        System.out.println(Arrays.toString(test.solution(5, new int[][]{
                {0, 0}, {0, -1}, {2, -3}, {3, -3}
        })));
    }
}

