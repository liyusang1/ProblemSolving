import java.util.*;

//다리의 길이만큼 원소가 0인 deque로 만들어서 접근
//원소들의 합이 다리의 무게를 넘지 않았다면 removeFirst, addLast(새로운트럭)으로 새로운 트럭을 deque에 추가
//무게를넘었다면 removeFirst, addLast(0)을 해줌으로서 트럭위치만 한칸 전진
//연산을 할때마다 시간을 더해서 답을 구함

public class Programmers_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Deque<Integer> bridge = new ArrayDeque<>(); //다리
        for (int i = 0; i < bridge_length; i++) {
            bridge.addLast(0);
        }

        Queue<Integer> truck = new LinkedList<>(); //남은트럭
        for (int i : truck_weights) {
            truck.add(i);
        }

        int curBridgeWeight = 0; //현재 다리의 무게
        while (!truck.isEmpty() || curBridgeWeight != 0) {
            if (!truck.isEmpty()) { //남은트럭이 없고 전부 다리에 올라가 있을 수 있기때문에 if로 조건처리
                int curTruck = truck.peek();
                curBridgeWeight -= bridge.getFirst(); //다리위에 맨 앞에 있는 트럭은 한칸 전진하기 때문에 다리의 무게에서 맨앞의 값만큼 뺌
                if (curBridgeWeight + curTruck <= weight) { //트럭이 하나 들어와서 다리의 무게가 견딜 수 있는경우
                    curBridgeWeight += curTruck;
                    bridge.addLast(curTruck);
                    truck.remove();
                } else { //트럭이 더 들어올 경우 다리의 무게가 견딜 수 없는경우 그냥 다리위의 트럭만 한칸전진
                    bridge.addLast(0);
                }
                bridge.removeFirst();
            } else { //트럭이 전부 다리위에 올라가 있다면 그냥 한칸씩 전진하면 됨
                curBridgeWeight -= bridge.removeFirst();
                bridge.addLast(0);
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_다리를지나는트럭 test = new Programmers_다리를지나는트럭();
        System.out.println(test.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(test.solution(100, 100, new int[]{10}));
        System.out.println(test.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));

    }
}

