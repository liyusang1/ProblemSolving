public class PCCE_지폐접기 {
    public static void main(String[] args) {
        PCCE_지폐접기 sol1 = new PCCE_지폐접기();
        sol1.solution(new int[]{30, 15}, new int[]{26, 17});
        sol1.solution(new int[]{50, 50}, new int[]{100, 241});
        sol1.solution(new int[]{5, 10}, new int[]{10, 11});

    }

    public int solution(int[] wallet, int[] bill) {
        int answer1 = 0;

        while (true) {
            if (bill[0] <= wallet[0] && bill[1] <= wallet[1]) {
                break;
            } else if (bill[0] <= wallet[1] && bill[1] <= wallet[0]) {
                break;
            }

            if(bill[0]> bill[1]){
                bill[0] = bill[0]/2;
            }
            else{
                bill[1] = bill[1]/2;
            }
            answer1++;
        }

        return answer1;
    }
}
