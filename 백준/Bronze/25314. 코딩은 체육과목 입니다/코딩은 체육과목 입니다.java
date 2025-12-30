import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int numLong = (n / 4) + (n % 4 == 0 ? 0 : 1);

        final String LONG_ = "long ";
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numLong; i++) {
            answer.append(LONG_);
        }
        answer.append("int");

        System.out.println(answer);
    }
}