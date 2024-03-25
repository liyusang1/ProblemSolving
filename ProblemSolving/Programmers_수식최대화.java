import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_수식최대화 {

    public long solution(String expression) {
        long answer = 0;

        String[] order = new String[]{
                "-*+",
                "*-+",
                "+*-",
                "*+-",
                "+-*",
                "-+*"
        };

        StringTokenizer stringTokenizer = new StringTokenizer(expression, "-+*", true);

        List<Long> numberList = new ArrayList<>();
        List<String> opsList = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            String temp = stringTokenizer.nextToken();
            if (Character.isDigit(temp.charAt(0))) {
                numberList.add(Long.parseLong(temp));
            } else {
                opsList.add(temp);
            }
        }

        for (String i : order) {
            String[] ops = i.split("");

            List<Long> tempNumberList = new ArrayList<>();
            List<String> tempOpsList = new ArrayList<>();
            //깊은복사
            for (Long tempNumber : numberList) {
                tempNumberList.add(tempNumber);
            }
            for (String tempOps : opsList) {
                tempOpsList.add(tempOps);
            }
            for (int k = 0; k < 3; k++) {
                int j = 0;
                while (j < tempOpsList.size()) {
                    if (ops[k].equals(tempOpsList.get(j))) {
                        if (ops[k].equals("+")) {
                            tempNumberList.set(j, tempNumberList.get(j) + tempNumberList.get(j + 1));
                        } else if (ops[k].equals("-")) {
                            tempNumberList.set(j, tempNumberList.get(j) - tempNumberList.get(j + 1));
                        } else if (ops[k].equals("*")) {
                            tempNumberList.set(j, tempNumberList.get(j) * tempNumberList.get(j + 1));
                        }
                        tempNumberList.remove(j + 1);
                        tempOpsList.remove(j);
                    } else {
                        j++;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(tempNumberList.get(0)));
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_수식최대화 test = new Programmers_수식최대화();
        System.out.println(test.solution("100-200*300-500+20")); //8
    }
}

