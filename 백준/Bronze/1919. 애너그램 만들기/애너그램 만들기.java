import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        final int NUM_LOWERCASE = 'z' - 'a' + 1;
        final int ASCII_A = 'a';
        int[] lowercaseFreqs = new int[NUM_LOWERCASE];

        for (char ch : s1) {
            lowercaseFreqs[ch - ASCII_A]++;
        }

        for (char ch : s2) {
            lowercaseFreqs[ch - ASCII_A]--;
        }

        int ans = 0;
        for (int f : lowercaseFreqs) {
            ans += Math.abs(f);
        }

        System.out.println(ans);
    }
}