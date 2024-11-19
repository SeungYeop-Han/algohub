import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    private static int cur = -1;
    private static int[] s = new int[100000];

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            int call = Integer.parseInt(br.readLine());
            if (call == 0 && cur != -1) {
                cur--;
            } else {
                s[++cur] = call;
            }
        }

        int ans = 0;
        for (int i = 0; i <= cur; i++) {
            ans += s[i];
        }
        System.out.println(ans);
    }
}