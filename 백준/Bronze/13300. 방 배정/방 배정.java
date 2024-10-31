import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numBoysEachGrade = new int[7];
        int[] numGirlsEachGrade = new int[7];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isBoy = (1 == Integer.parseInt(st.nextToken()));
            int grade = Integer.parseInt(st.nextToken());
            if (isBoy) {
                numBoysEachGrade[grade]++;
            } else {
                numGirlsEachGrade[grade]++;
            }
        }

        int numRoomsNeeded = 0;
        for (int grade = 1; grade <= 6; grade++) {
            numRoomsNeeded += Math.ceil((double) numBoysEachGrade[grade] / k);
            numRoomsNeeded += Math.ceil((double) numGirlsEachGrade[grade] / k);
        }

        System.out.println(numRoomsNeeded);
    }
}