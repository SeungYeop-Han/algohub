import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
  
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder answer = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    LinkedList<Integer> list = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      list.add(i);
    }

    ListIterator<Integer> it = list.listIterator();
    answer.append("<");
    while (!list.isEmpty()) {
      int target = 0;
      for (int i = 0; i < k; i++) {
        if (it.hasNext()) {
          target = it.next();
        } else {
          it = list.listIterator();
          target = it.next();
        }
      }

      it.remove();
      answer.append(target).append(", ");
    }

    answer.delete(answer.length() - 2, answer.length());
    answer.append(">");

    System.out.println(answer);
  }
}