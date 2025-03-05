import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int numWords = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        while(numWords-- > 0) {

            String word = br.readLine();
            
            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }

                if (stack.peek() == '(' && ch == ')') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                answer.append("YES\n");
            } else {
                answer.append("NO\n");
            }

            stack.clear();
        }

        System.out.println(answer);
    }
}