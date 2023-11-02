import java.util.*;

public class Programmers_불량사용자_recursion {

    HashSet<String> set = new HashSet<>();
    boolean[] visited;

    public int solution(String[] userid, String[] banid) {
        visited = new boolean[userid.length];

        for (int i=0; i<banid.length; i++) {
            banid[i] = banid[i].replace('*', '.');
        }

        recur(userid,banid,"",0);

        return set.size();
    }

    public void recur(String [] userid,String [] banid,String temp,int length) {
        if(length== banid.length){
            String [] words = temp.split(" ");
            Arrays.sort(words);

            String wordsToString = "";
            for(String i : words){
                wordsToString+=i;
            }
            set.add(wordsToString);
            return;
        }

        for(int i=0; i<userid.length; i++){
            if(visited[i] || !userid[i].matches(banid[length])){
                continue;
            }
            visited[i]=true;
            recur(userid,banid,userid[i]+" "+temp,length+1); //tlqkf 어떻게 이걸 생각하지
            visited[i]=false;
        }
    }


    public static void main(String[] args) {
        Programmers_불량사용자_recursion test = new Programmers_불량사용자_recursion();
        System.out.println(test.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "abc1**"}));
    }
}

