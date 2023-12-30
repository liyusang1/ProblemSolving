import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2512 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int sum = Integer.parseInt(br.readLine());

        list.sort(Comparator.reverseOrder());
        int answer = list.get(0);
        int curSum = 0;

        while(true){
            for(int cur : list){
                if(answer>cur){
                    curSum+=cur;
                }else{
                    curSum+=answer;
                }
            }
            if(curSum>sum){
                curSum=0;
                answer--;
            }else{
                break;
            }
        }

        System.out.println(answer);
    }
}
