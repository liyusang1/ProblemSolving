package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5073 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [] arr = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            int max = Math.max(Math.max(arr[0], arr[1]), arr[2]);
            int sum = 0;
            sum += arr[0];
            sum += arr[1];
            sum += arr[2];
            int left = sum - max;

            if(arr[0]==0 && arr[1]==0 && arr[2]==0){
                break;
            }

            else if(left <= max){
                System.out.println("Invalid");
            }

            else if(arr[0]==arr[1] && arr[0]==arr[2]){
                System.out.println("Equilateral");
            }

            else if (arr[0]==arr[1] || arr[0]==arr[2] || arr[1]==arr[2]){
                System.out.println("Isosceles");
            }

            else{
                System.out.println("Scalene");
            }
        }
    }
}
