import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String... args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator();

            for (char keyLog : br.readLine().toCharArray()) {

                if (keyLog == '<') {
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                } else if (keyLog == '>') {
                    if (it.hasNext()) {
                        it.next();
                    }
                } else if (keyLog == '-') {
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                } else {
                    it.add(keyLog);
                }
            }

            list.stream().forEach(answer::append);
            answer.append("\n");
        }

        System.out.println(answer);
    }
}