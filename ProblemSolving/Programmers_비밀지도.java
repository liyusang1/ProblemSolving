public class Programmers_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] string1 = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (temp.length() < n) {
                temp = '0' + temp;
            }
            string1[i] = temp;
        }

        for (int i = 0; i < string1.length; i++) {
            string1[i] = string1[i].replace("1", "#");
            string1[i] = string1[i].replace("0", " ");
        }

        return string1;
    }

    public static void main(String[] args) {
        Programmers_비밀지도 test = new Programmers_비밀지도();
    }
}

