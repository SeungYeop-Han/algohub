import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] m = new int[n + 1];
        m[0] = 0;
        m[1] = 0;

        for (int i = 2; i <= n; i++) {

            int min = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                min = Math.min(min, m[i / 3]);
            }
            if (i % 2 == 0) {
                min = Math.min(min, m[i / 2]);
            }
            min = Math.min(min, m[i - 1]);

            m[i] = min + 1;
        }

        System.out.println(m[n]);
    }
}
