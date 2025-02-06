import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 원형 덱(구현의 단순화를 위해 내부 배열의 크기를 처음부터 최대 값으로 잡았음)
public class Main {

    // head, tail 이 가리키고 있는 위치는 유효하지 않은 원소임
    static int CAP = 10002;
    static int[] deq = new int[CAP];
    static int head = 0;
    static int tail = 1;
    static int size = 0;

    static boolean isEmpty() {
        return size == 0;
    }

    static int prev(int idx) {
        return (idx + (CAP - 1)) % CAP;
    }

    static int next(int idx) {
        return (idx + 1) % CAP;
    }

    static int front() {
        return isEmpty() ? -1 : deq[next(head)];
    }

    static int back() {
        return isEmpty() ? -1 : deq[prev(tail)];
    }

    static int pop_front() {
        if (isEmpty()) {
            return -1;
        }
        
        size--;
        return deq[head = next(head)];
    }

    static int pop_back() {
        if (isEmpty()) {
            return -1;
        }

        size--;
        return deq[tail = prev(tail)];
    }

    static void push_front(int e) {
        deq[head] = e;
        head = prev(head);
        size++;
    }

    static void push_back(int e) {
        deq[tail] = e;
        tail = next(tail);
        size++;
    }

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            
            int NO_OUTPUT = Integer.MAX_VALUE;
            int out = NO_OUTPUT;

            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "size"         : out = size; break;
                case "empty"        : out = isEmpty() ? 1 : 0; break;
                case "front"        : out = front(); break;
                case "back"         : out = back(); break;
                case "pop_front"    : out = pop_front(); break;
                case "pop_back"     : out = pop_back();  break;
                case "push_front"   : push_front(Integer.parseInt(st.nextToken())); break;
                case "push_back"    : push_back(Integer.parseInt(st.nextToken())); break;
            }

            if (out != NO_OUTPUT) {
                answer.append(out).append("\n");
            }
        }

        System.out.println(answer);
    }
}