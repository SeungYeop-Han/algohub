import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

public class Main {

    // 야매 스택
    static int pos = -1;
    static int[] stack = new int[50000];

    static void push(int e) {
        stack[++pos] = e;
    }

    static int pop() throws EmptyStackException {
        if (pos == -1) {
            throw new EmptyStackException();
        }

        return stack[pos--];
    }

    //-------------------
    
    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열은 항상 유효한 괄호쌍임
        String seq = br.readLine();

        // 정답
        int ans = 0;

        // 괄호 문자열 순회
        for (int idxSeq = 0; idxSeq < seq.length(); idxSeq++) {

            char cur = seq.charAt(idxSeq);

            if (cur == '(') {
                push(1);
                continue;
            }

            if (cur == ')') {

                // 레이저인 경우 stack 이 모든 요소 +1
                // 항상 올바른 괄호쌍이므로, ')' 문자가 제시된 경우 반드시 이전 문자가 존재함이 보장됨
                if (seq.charAt(idxSeq-1) == '(') {
                    // 레이저 제거
                    pop();

                    // stack 의 모든 요소 +1
                    for (int idxStack = 0; idxStack <= pos; idxStack++) {
                        stack[idxStack]++;
                    }
                } else { // 레이저가 아닌 경우 popped 를 정답에 누적
                    ans += pop();
                }
            }
        }

        System.out.println(ans);
    }
}