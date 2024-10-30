import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int abc = a * b * c;
        String s = Integer.toString(abc);

        int[] freqs = new int[10];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int freq : freqs) {
            sb.append(freq).append('\n');
        }

        System.out.println(sb);
    }
}