
public class Programmers_순위_플로이드와셜 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] arr = new int[n + 1][n + 1];

        for (int[] result : results) {
            int a = result[0];
            int b = result[1];

            //a가 b를 이겼다는 의미 -> a>b임
            arr[a][b] = 1;
            arr[b][a] = -1;
        }

        //    1 2 3  4 5
        // 1    1
        // 2 -1  -1 -1 1
        // 3    1   -1
        // 4    1 1
        // 5   -1
        // 그래프 형식으로 만들어서 n-1만큼 비어있는 칸은 모든 경기를 한것

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // [4,3],[3,2] 이면 4번이 2번을 이기는것은 당연함 -> 4번이 3번을 이겻는데 3번이 2번을 이겻으니
                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j]=1;
                        arr[j][i]=-1;
                    }
                    //반대 경우
                    if(arr[i][k]==-1 && arr[k][j]==-1){
                        arr[i][j]=-1;
                        arr[j][i]=1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            int count = 0;
            for (int j=1; j<=n; j++){
                if(arr[i][j]!=0){
                    count++;
                }
            }
            //arr을 순회하면서 0이 아닌 수를 찾았을 때 n-1과 같다면 모든 사람과 경기를 한것임
            if(n-1==count){
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Programmers_순위_플로이드와셜 test = new Programmers_순위_플로이드와셜();
        System.out.println(test.solution(5, new int[][]{
                {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        }));
    }
}

