import java.util.*;

public class Programmers80 {
    public int solution(String word) {
        int answer = -1;

        String [] arr = new String[]{"A", "E", "I", "O", "U"};
        List<String> list = new ArrayList<>();
        recur(list,"",0,arr);

        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    public void recur (List list,String string,int depth,String[] arr) {
        list.add(string);

        if(depth==5){
            return;
        }

        for(int i=0; i<5;i++){
            recur(list,string+arr[i],depth+1,arr);
        }
    }

    public static void main(String[] args) {

        Programmers80 test = new Programmers80();
        System.out.println(test.solution("AAAAE"));
    }
}
