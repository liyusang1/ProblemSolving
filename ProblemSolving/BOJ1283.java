package _BOJPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1283 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        StringBuilder answer = new StringBuilder();


        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();

            String[] temp = arr[i].split(" ");

            boolean isChecked = false;

            //첫번째 글자만 검사
            for (int j = 0; j < temp.length; j++) {
                if (!map.containsKey(temp[j].toLowerCase().charAt(0))) {
                    map.put(temp[j].toLowerCase().charAt(0), 1);
                    isChecked = true;

                    temp[j] = "[" + temp[j].charAt(0) + "]" + temp[j].substring(1);
                    break;
                }
            }

            if (!isChecked) {
                outerLoop:
                for (int j = 0; j < temp.length; j++) {
                    for (int k = 1; k < temp[j].length(); k++) {

                        if (!map.containsKey(temp[j].toLowerCase().charAt(k))) {
                            map.put(temp[j].toLowerCase().charAt(k), 1);

                            temp[j] = temp[j].substring(0, k) + "[" + temp[j].charAt(k) + "]" + temp[j].substring(k + 1);
                            break outerLoop;
                        }
                    }
                }
            }

            for (int j = 0; j < temp.length; j++) {
                answer.append(temp[j]).append(" ");
            }
            answer.append("\n");

        }


        System.out.println(answer);
    }
}


//[N]ew window
//New [f]ile
//[C]opy
//[U]ndo
//F[o]rmat
//Fon[t]
//Cut
//[P]aste