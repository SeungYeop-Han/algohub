import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

class Main {
    
    final boolean LAND = true;
    final boolean SEA = false;
    
    int width, height;
    boolean[][] map;
    boolean[][] visited;
    int[][] directions = {
        // {height diff, width diff}
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, /*self*/ {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };
    
    StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    // ↓↓↓

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            
            if (width == 0 && height == 0) {
                break;
            }

            map = new boolean[height][width];
            visited = new boolean[height][width];
            
            for (int row = 0; row < height; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < width; col++) {
                    map[row][col] = st.nextToken().equals("1") ? LAND : SEA;
                }
            }
            
            solve();
        }

        System.out.println(ans);
    }

    // ↓↓↓

    void solve() {

        int landCount = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (map[row][col] == LAND && !visited[row][col]) {
                    ++landCount;
                    dfsLand(row, col);
                }
            }
        }

        ans.append(landCount).append("\n");
    }

    // ↓↓↓
    
    void dfsLand(int row, int col) {

        visited[row][col] = true;
        
        for (int[] offset : directions) {
            int rowNext = row + offset[0];
            int colNext = col + offset[1];
            if (isCoordValid(rowNext, colNext) && map[rowNext][colNext] == LAND && !visited[rowNext][colNext]) {
                dfsLand(rowNext, colNext);
            }
        }
    }

    // ↓↓↓

    boolean isCoordValid(int row, int col) {
        return 0 <= row && row < height && 0 <= col && col < width;
    }
}