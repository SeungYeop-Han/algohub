import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

class Main {
    
    int numVertices;
    int numEdges;
    int entryPoint;
    
    boolean[][] graph = new boolean[1001][1001];
    boolean[] visited = new boolean[1001];
    boolean[] offered = new boolean[1001];
    
    StringBuilder dfsOut = new StringBuilder();
    StringBuilder bfsOut = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        init();
        dfs();
        bfs();
    };

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        numVertices = Integer.parseInt(st.nextToken());
        numEdges = Integer.parseInt(st.nextToken());
        entryPoint = Integer.parseInt(st.nextToken());

        String lineRead;
        while ((lineRead = br.readLine()) != null) {
            st = new StringTokenizer(lineRead);
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            graph[fromVertex][toVertex] = true;
            graph[toVertex][fromVertex] = true;
        }
    }    

    void dfs() {
        visit(entryPoint);
        System.out.println(dfsOut);
    }
    void visit(int toVisit) {
        visited[toVisit] = true;
        dfsOut.append(toVisit).append(" ");

        for (int v = 1; v <= numVertices; v++) {
            if (graph[toVisit][v] && !visited[v]) {
                visit(v);
            }
        }
    }
    
    void bfs() {
        Deque<Integer> q = new LinkedList<>();

        q.offer(entryPoint);
        offered[entryPoint] = true;
        
        Integer polled;
        while ((polled = q.poll()) != null) {
            
            bfsOut.append(polled).append(" ");
            
            for (int v = 1; v <= numVertices; v++) {
                if (graph[polled][v] && !offered[v]) {
                    offered[v] = true;
                    q.offer(v);
                }
            }
        }
        
        System.out.println(bfsOut);
    }
}