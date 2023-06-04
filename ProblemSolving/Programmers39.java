import java.util.Arrays;

public class Programmers39 {
    public String solution(String phone_number) {
        String temp1 = phone_number.substring(phone_number.length() - 4);
        String temp2 = "";

        for (int i = 0; i < phone_number.length() - 4; i++) {
            temp2 += "*";
        }

        return temp2 + temp1;
    }

    public static void main(String[] args) {

        Programmers39 test = new Programmers39();
        System.out.println(test.solution("0109999999"));
    }
}
