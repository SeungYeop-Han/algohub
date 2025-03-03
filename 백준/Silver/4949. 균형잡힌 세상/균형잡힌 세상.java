import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while (true) {

            // 입력
            String line = br.readLine();

            // 종료 조건
            if (line.equals(".")) {
                break;
            }

            // 문자열의 각 문자를 순서대로 순회
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                // 만약 여는 괄호인 경우 스택에 삽입
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }

                // 만약 닫는 괄호인 경우 스택의 가장 앞 문자와 비교
                if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isBalanced = false;
                        break;
                    }

                    stack.pop();
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    }

                    stack.pop();
                }
            }

            // 괄호 스택이 비어있지 않은 경우 균형이 어긋난 상태임
            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            // 출력
            if (isBalanced) {
                ans.append("yes\n");
            } else {
                ans.append("no\n");
            }
        }

        System.out.println(ans);
    }
}