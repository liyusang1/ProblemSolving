public class Programmers_신규아이디추천_Regex {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase()
                .replaceAll("[^a-z0-9_.-]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (answer.length() == 0) {
            answer += "a";
        }
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15).
                    replaceAll("[.]$", "");
        }
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_신규아이디추천_Regex test = new Programmers_신규아이디추천_Regex();
        System.out.println((test.solution("...!@BaT#*..y.abcdefghijklm")));
        System.out.println((test.solution("abcdefghijklmn.p")));
    }
}

