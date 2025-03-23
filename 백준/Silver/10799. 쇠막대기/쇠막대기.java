import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열은 항상 유효한 괄호쌍임
        String seq = br.readLine();

        // 가상의 스택에 삽입된 쇠막대기의 수
        int stackSize = 0;

        // 정답(절편의 수)
        int ans = 0;

        // 괄호 문자열 순회
        for (int idxSeq = 0; idxSeq < seq.length(); idxSeq++) {

            char cur = seq.charAt(idxSeq);

            // 가상의 스택에 쇠막대기가 push 되었음
            if (cur == '(') {
                stackSize++;
            }

            // seq는 항상 올바른 괄호쌍이므로, ')' 문자가 제시된 경우 반드시 이전 문자가 존재함이 보장됨
            else {

                // 직전에 push 한 쇠막대기가 레이저 였으므로
                if (seq.charAt(idxSeq-1) == '(') {
                    // 가상의 스택으로부터 pop 해야 함
                    stackSize--;

                    // 레이저에 의해 절단된, 왼쪽 절편의 수(==stackSize) 를 정답에 누적
                    ans += stackSize;
                }
                
                // 가장 짧았던 쇠막대기의 끝 지점인 경우
                // 가상의 스택으로부터 쇠막대기를 제거하면서 정답에 누적
                else {
                    stackSize--;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}