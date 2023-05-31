public class Programmers24 {

    public int solution(String s) {

        String[] number = new String[]{
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };

        for (int i = 0; i < number.length; i++) {
            if (s.contains(number[i])) {
                s = s.replace(number[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }


    public static void main(String[] args) {

        Programmers24 test = new Programmers24();

        System.out.println(test.solution("one4sevenzeroeight"));
        System.out.println(test.solution("one4seveneight"));
        System.out.println(test.solution("23four5six7"));
        System.out.println(test.solution("2three45sixseven"));
        System.out.println(test.solution("123"));
    }
}
