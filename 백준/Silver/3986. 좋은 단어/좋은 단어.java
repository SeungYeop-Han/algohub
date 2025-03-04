import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numGoodWords = 0;

        int numWords = Integer.parseInt(br.readLine());
        while(numWords-- > 0) {

            String word = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }

                if (ch == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                numGoodWords++;
            }
        }

        System.out.println(numGoodWords);
    }
}