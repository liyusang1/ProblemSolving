import java.util.*;

public class Programmers_다트게임 {
    public int solution(String dartResult) {

        String[] string = dartResult.split("");
        int[] score = new int[3];
        int index = -1;

        for (int i = 0; i < string.length; i++) {

            if (string[i].matches("[0-9]")) {
                index++;
                if (string[i + 1].matches("[0-9]")) {
                    score[index] = 10;
                    i++;
                } else {
                    score[index] = Integer.parseInt(string[i]);
                }
            }

            switch (string[i]) {
                case "D":
                    score[index] = (int) Math.pow(score[index], 2);
                    break;
                case "T":
                    score[index] = (int) Math.pow(score[index], 3);
                    break;
                case "*":
                    score[index] *= 2;
                    if (index >= 1) {
                        score[index - 1] *= 2;
                    }
                    break;
                case "#":
                    score[index] *= -1;
                    break;
            }
        }

        return score[0] + score[1] + score[2];
    }

    public static void main(String[] args) {
        Programmers_다트게임 test = new Programmers_다트게임();
    }
}

