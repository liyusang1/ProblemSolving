import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ25757 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int len = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> member = new HashSet<>();

        for(int i=0; i<len; i++) {
            member.add(br.readLine());
        }

        int answer= 0 ;

        if(game.equals("Y")){
            answer += member.size();
        }
        else if(game.equals("O")){
            answer += member.size()/3;
        }
        else if(game.equals("F")){
            answer += member.size()/2;
        }

        System.out.println(answer);
    }
}
