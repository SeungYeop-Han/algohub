import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알파벳 개수(백준 10808; 브론즈4)
 * 구현, 문자열
 */
public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] freqs = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int freq : freqs) {
            sb.append(freq).append(' ');
        }

        System.out.println(sb);
    }
}