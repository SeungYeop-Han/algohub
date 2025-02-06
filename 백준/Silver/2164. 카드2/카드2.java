import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] q = new int[1_000_000];
    static int head = 0;
    static int tail = 0;

    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 큐 초기화
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            q[tail++] = i;
        }

        // 요소가 하나가 남을 때 까지 반복
        while (tail - head > 1) {
            head++;                 // pop
            q[tail++] = q[head++];  // pop & push poped
        }

        System.out.println(q[head]);
    }
}