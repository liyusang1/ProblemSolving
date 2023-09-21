import java.util.*;

public class Programmers_혼자놀기의달인 {
    boolean[] cardArr;  // 카드를 뽑은 적이 있는지 저장하는 배열
    int[] cards;  // 카드 뭉치
    int count;  // 뽑은 카드 수

    public int solution(int[] cards) {
        this.cards = cards;
        cardArr = new boolean[cards.length];
        ArrayList<Integer> list = new ArrayList<>();

        // 카드 뭉치의 카드의 개수만큼 반복
        for (int i = 0; i < cards.length; i++) {
            // 뽑은 적이 있는 카드면 뽑지 않고 다음 카드를 가져옴
            if (cardArr[i]) continue;

            count = 1;  // 이번 루틴에서 뽑은 카드 개수 + 1;
            cardArr[i] = true;
            recur(cards[i] - 1);
            list.add(count);
        }

        // 리스트에 저장된 count를 내림차순으로 정렬
        list.sort(Comparator.reverseOrder());

        // 최소 루틴의 횟수는 2회므로, 1회인경우 곱할 수 없으므로 0 반환
        return list.size() == 1 ? 0 : (list.get(0) * list.get(1));
    }

    public void recur(int index) {
        // 이미 뽑은 적이 있는 카드라면 함수를 종료
        if (cardArr[index]) return;

        cardArr[index] = true;
        count++;
        recur(cards[index] - 1);  // 카드에 적혀 있는 숫자의 위치에 있는 카드 가져오기
    }

    public static void main(String[] args) {
        Programmers_혼자놀기의달인 test = new Programmers_혼자놀기의달인();
        System.out.println(test.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
    }
}

