public class Programmers27 {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i=0; i<absolutes.length;i++){
            if (signs[i]){
                answer += absolutes[i];
            }
            else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Programmers27 test = new Programmers27();
        System.out.println(test.solution(new int[]{4,7,12},new boolean[]{true,false,true}));
    }
}
