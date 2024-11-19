import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static int cur = -1;
    private static int[] s = new int[10000];

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" : s[++cur] = Integer.parseInt(st.nextToken()); break;
                case "top"  : sb.append(cur == -1 ? -1 : s[cur]).append('\n'); break;
                case "pop"  : sb.append(cur == -1 ? -1 : s[cur--]).append('\n'); break;
                case "size" : sb.append(cur + 1).append('\n'); break;
                case "empty": sb.append(cur == -1 ? 1 : 0).append('\n'); break;
            }
        }

        System.out.println(sb);
    }
}