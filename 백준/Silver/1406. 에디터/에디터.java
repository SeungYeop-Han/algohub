import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> list = new LinkedList<>();

        ListIterator<Character> lit = list.listIterator();
        for (char ch : br.readLine().toCharArray()) {
            lit.add(ch);
        }

        int numOps = Integer.parseInt(br.readLine());
        while (numOps-- > 0) {

            String op = br.readLine();
            char directive = op.charAt(0);

            boolean isRemovable = false;
            boolean isfoward = true;

            if (directive == 'L') {
                isfoward = false;
                isRemovable = true;
                if (lit.hasPrevious()) {
                    lit.previous();
                }
            } else if (directive == 'D') {
                isfoward = true;
                isRemovable = true;
                if (lit.hasNext()) {
                    lit.next();
                }
            } else if (directive == 'B') {
                if (isRemovable && isfoward) {  // 전방향 조회 직후
                    lit.remove();
                } else if (lit.hasPrevious()) { // 역방향 조회 또는 삽입 직후
                    lit.previous();
                    lit.remove();
                } else {
                    // 역방향 조회 후 커서가 가장 앞에 위치하게 된
                    // 경우에는 삭제할 요소가 없음
                }

                isRemovable = false;
            } else {
                isRemovable = false;
                char ch = op.charAt(2);
                lit.add(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        list.stream().forEach(e -> result.append(e));
        System.out.println(result);
    }
}