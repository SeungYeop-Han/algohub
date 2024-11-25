import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // s1: 1~n 순서로 값을 찾을수만 있는 가상 스택
    static int s1Top = 1;

    // s2
    static int[] s2;
    static int cursor = -1;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        s2 = new int[n];

        for (int i = 0; i < n; i++) {
            int e = Integer.parseInt(br.readLine());

            for (int j = e - s1Top + 1; j > 0; j--) {
                // s1 pop
                int s1Poped = s1Top++;

                // s2 push
                s2[++cursor] = s1Poped;
                answer.append("+\n");
            }

            // cursor는 -1이 되지 않음이 보장됨
            if (s2[cursor] == e) {
                // s2 pop
                cursor--;
                answer.append("-\n");
            } else {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println(answer);
    }
}