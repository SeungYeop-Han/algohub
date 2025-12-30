import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numJar = Integer.parseInt(st.nextToken());
        int repeat = Integer.parseInt(st.nextToken());

        int[] jars = new int[numJar + 1];
        for (int i = 0; i < repeat; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int ballNum = Integer.parseInt(st.nextToken());

            for (int j = from; j <= to; j++) {
                jars[j] = ballNum;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= numJar; i++) {
            answer.append(jars[i]).append(" ");
        }
        System.out.println(answer);
    }
}