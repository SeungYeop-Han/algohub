import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int mult = n1 * n2;
        
        while(n2 != 0) {
            System.out.println(n1 * (n2 % 10));
            n2 /= 10;
        }
        System.out.println(mult);
    }
}