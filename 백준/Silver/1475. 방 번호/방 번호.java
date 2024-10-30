import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        char[] s = Integer.toString(n).toCharArray();
        int[] freqs = new int[10];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '6' || s[i] == '9') {
                s[i] = '9';
                freqs[9]++;
            } else {
                freqs[s[i] - '0'] += 2;
            }
        }

        int max = -1;
        for (int f : freqs) {
            if (f > max) {
                max = f;
            }
        }

        long ans = Math.round(max / 2.0);
        System.out.println(ans);
    }
}