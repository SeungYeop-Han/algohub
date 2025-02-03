import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
    static Stack<Tower> stack = new Stack<>();

    public static void main(String... args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 탑의 개수를 입력 받습니다.
        int numTowers = Integer.parseInt(br.readLine());

        // 아래 두 배열의 인덱스는 탑의 번호(순번)를 의미합니다.(인덱스 0 은 사용하지 않습니다)
        // height 배열은, 각각의 인덱스에 대응하는 탑의 높이를 의미합니다.
        // answer 배열은, 각각의 인덱스에 대응하는 탑에서 송신된 신호가 도달하게 되는 탑의 번호를 저장합니다.
        int[] answer = new int[numTowers + 1];
        int[] heights = new int[numTowers + 1];

        // 타워 높이를 입력 받습니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numTowers; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // heights 배열을 역방향으로 순회합니다. (수직선 상의 오른쪽에서 왼쪽으로 순회)
        for (int i = numTowers; i > 0; i--) {

            // 만약 스택이 비어있지 않다면
            // 현재 순회 중인 탑과 가장 최근에 삽입된 탑의 높이를 비교합니다.
            //   - 만약 현재 순회 중인 탑의 높이가 더 높다면(같은 경우는 없음), 
            //     가장 최근에 삽입된 탑의 신호는 현재 순회 중인 탑에 도달합니다.
            //   - 현재 순회 중인 탑의 높이가 더 높거나, 스택이 빌 때 까지 반복합니다.
            while (!stack.isEmpty()) {
                Tower top = stack.peek();
                if (heights[i] > top.height) {
                    answer[top.order] = i;
                    stack.pop();
                } else {
                    break;
                }
            }

            // 현재 순회 중인 탑을 스택에 삽입합니다.
            stack.push(new Tower(i, heights[i]));
        }

        // 스택에 남아있는 탑들의 신호는 어느 탑에도 도달하지 못하므로,
        // answer 배열의 대응하는 위치에 0 을 할당합니다.
        while (!stack.isEmpty()) {
            answer[stack.pop().order] = 0;
        }

        // 정답을 출력합니다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numTowers; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}

// 탑은 높이와 순번을 가집니다.
class Tower {
    public int order;
    public int height;

    public Tower(int id, int height) {
        this.order = id;
        this.height = height;
    }
}