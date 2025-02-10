/* [문제 분석]

    인접한 위치에 두 빗금이 있는 원형 다이얼을 생각해보자.
    초기 상태일 때, 1번 위치에 front 다이얼이, n번 위치에 back 다이얼이 존재한다.

    이때, 다음의 3 가지 연산만을 수행할 수 있다.
        - 연산 1: front 빗금 위치의 요소를 제거
        - 연산 2: 다이얼을 한 쪽 방향으로 돌리기
            - (기존 front 빗금이 가리키던 요소가 back 빗금으로 가게끔)
        - 연산 3: 다이얼을 반대 방향으로 돌리기
            - (기존 back 빗금이 가리키던 요소가 front 빗금으로 가게끔)
    
    주어진 순서대로 요소를 제거해야 할 때,
        - 왔다 갔다 하는 건 의미가 없다. 어느 방향으로 몇 번 돌릴 지 결정해야 한다.
        - front 빗금 위치에 있는 요소만 제거(연산 1)할 수 있다.
            - 이는 특정 요소를 제거한 뒤의 다이얼의 상태가 동일함을 의미한다.
        - 결론적으로, 덜 돌릴 수 있는 방향으로 돌리면 된다.(탐욕법)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int queueSize = Integer.parseInt(st.nextToken());
        int numItemShouldRemove = Integer.parseInt(st.nextToken());

        // 덱 초기화
        Deque<Integer> deq = new ArrayDeque<>(queueSize);
        for (int e = 1; e <= queueSize; e++) {
            deq.addLast(e);
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numItemShouldRemove; i++) {
            
            int target = Integer.parseInt(st.nextToken());

            /* 
                방향을 결정하기 위해 두 방향으로 모두 돌려볼 필요는 없다.
                결국 목표하는 요소를 제거하기 위해서는 같은 상태여야 하기 때문에
                한쪽 방향으로 돌렸을 때의 횟수를 알면,
                반대 방향으로 돌렸을 때의 횟수를 알 수 있다.
                둘 중 작은 값을 답에 누적한다.
             */
        
            int tick = 0;
            while (!deq.peekFirst().equals(target)) {
                deq.addLast(deq.pollFirst());
                tick++;
            }
            answer += Math.min(tick, deq.size() - tick);
            deq.pop();
        }

        System.out.println(answer);
    }
}