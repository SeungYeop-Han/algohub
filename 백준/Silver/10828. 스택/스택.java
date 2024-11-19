import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        
        MyStack stack = new MyStack(10000);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String op = br.readLine();
            if (op.startsWith("push")) {
                int e = Integer.parseInt(op.split(" ")[1]);
                stack.push(e);
            } else if (op.startsWith("top")) {
                if (stack.empty()) {
                    answer.append(-1).append('\n');
                } else {
                    answer.append(stack.top()).append('\n');
                }
            } else if (op.startsWith("pop")) {
                if (stack.empty()) {
                    answer.append(-1).append('\n');
                } else {
                    answer.append(stack.pop()).append('\n');
                }
            } else if (op.startsWith("size")) {
                answer.append(stack.size()).append('\n');
            } else {
                // empty
                if (stack.empty()) {
                    answer.append(1).append('\n');
                } else {
                    answer.append(0).append('\n');
                }
            }
        }

        System.out.println(answer);
    }
}

class MyStack {
    
    private int capacity;
    private int cursor;
    private int[] arr;

    public MyStack() {
        this(10);
    }

    public MyStack(int initialCapacity) {

        if (initialCapacity < 1) {
            throw new IllegalArgumentException("초기 크기는 양수여야 합니다.");
        }

        this.capacity = initialCapacity;
        arr = new int[capacity];

        // empty
        cursor = -1;
    }

    public void push(int e) {

        if (capacity <= cursor) {
            int[] temp = new int[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                temp[i] = arr[i];
            }
            capacity *= 2;
        }

        arr[++cursor] = e;
    }

    public int top() {

        if (cursor == -1) {
            throw new IllegalStateException("요소가 없습니다.");
        }

        return arr[cursor];
    }

    public int pop() {

        if (cursor == -1) {
            throw new IllegalStateException("요소가 없습니다.");
        }

        return arr[cursor--];
    }

    public int size() {

        return cursor + 1;
    }

    public boolean empty() {

        return cursor == -1;
    }
}