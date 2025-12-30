import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cookingMinuite = Integer.parseInt(br.readLine());

        m += cookingMinuite;
        h = (h + (m / 60)) % 24;
        m = m % 60;

        System.out.println(h + " " + m);
    }
}