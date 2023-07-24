import java.util.*;
//프로그래머스 전화번호 목록
public class Programmers98 {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {

            int len1 = phone_book[i].length();
            int len2 = phone_book[i + 1].length();

            if (len1 < len2) {
                if (phone_book[i].equals(phone_book[i + 1].substring(0, len1))) {
                    return false;
                }
            } else {
                if (phone_book[i + 1].equals(phone_book[i].substring(0, len2))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Programmers98 test = new Programmers98();
        System.out.println(test.solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}

