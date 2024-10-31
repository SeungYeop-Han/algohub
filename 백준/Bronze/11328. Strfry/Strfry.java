import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] s1 = st.nextToken().toCharArray();
            char[] s2 = st.nextToken().toCharArray();
            Arrays.sort(s1);
            Arrays.sort(s2);
            if (Arrays.equals(s1, s2)) {
                answer.append("Possible").append("\n");
            } else {
                answer.append("Impossible").append("\n");
            }
        }

        System.out.println(answer);
    }
}