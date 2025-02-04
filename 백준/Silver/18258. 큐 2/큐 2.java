import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 야매 큐 구현(2,000,000 번의 연산을 초과하면 올바르게 동작하지 않을 수 있음)
public class Main {

    static int[] q = new int[2_000_000];
    static int head = 0;
    static int tail = 0;

    static boolean isEmpty() {
        return head == tail;
    }

    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push"  : q[tail++] = Integer.parseInt(st.nextToken());                break;
                case "pop"   : sb.append(isEmpty() ? -1 : q[head++]).append("\n");      break;
                case "empty" : sb.append(isEmpty() ? 1 : 0).append("\n");               break;
                case "front" : sb.append(isEmpty() ? -1 : q[head]).append("\n");        break;
                case "back"  : sb.append(isEmpty() ? -1 : q[tail - 1]).append("\n");    break;
                case "size"  : sb.append(Math.abs(tail - head)).append("\n");           break;
            }
        }

        System.out.println(sb);
    }
}