import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알파벳 개수(백준 10808; 브론즈4)
 * 시간 제한: 1초; 메모리 제한 128MB
 * 수학, 구현, 사칙연산
 */
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