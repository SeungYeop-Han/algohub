import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* ToDo

    1. 입력 테스트 케이스가 여럿인 경우에 대한 깔끔한 구현 방안 마련
    2. LinkedList 정리
    3. 문자열 조작 API 정리
 */

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numTestCases;
    String commands;
    int n;
    LinkedList<Integer> nums = new LinkedList<>();

    void solution() throws Exception {

        int numTestCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numTestCases; i++) {

            takeInput();

            boolean dirToggle = false;  // f: 정(->), t: 역(<-)
            boolean isError = false;
            for (int j = 0; j < commands.length(); j++) {
                char cmd = commands.charAt(j);
                if (cmd == 'R') {
                    dirToggle = !dirToggle;
                    continue;
                }

                if (nums.size() == 0) {
                    isError = true;
                    break;
                } 
                
                if(dirToggle == false) {
                    nums.removeFirst();
                } else {
                    nums.removeLast();
                }
            }

            printAnswer(isError, dirToggle);
        }
    }

    void takeInput() throws Exception {

        commands = br.readLine();
        n = Integer.parseInt(br.readLine());
        String numString = br.readLine();
        
        // [] 제거
        numString = numString.substring(1, numString.length()-1);

        // 토큰화(,)
        StringTokenizer st = new StringTokenizer(numString, ",");
        for (int i = 0; i < n; i++) {
            nums.addLast(Integer.parseInt(st.nextToken()));
        }
    }

    void printAnswer(boolean isError, boolean dirToggle) {

        if (isError) {
            System.out.println("error");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        int size = nums.size();
        for (int i = 0; i < size; i++) {

            int num;
            if (dirToggle) {
                num = nums.removeLast();
            } else {
                num = nums.removeFirst();
            }

            sb.append(num);
            
            if (i != size-1) {
                sb.append(",");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}