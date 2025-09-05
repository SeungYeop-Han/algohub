import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        
        int numFeat = speeds.length;
        int[] daysLeft = new int[numFeat];
        for (int i = 0; i < numFeat; i++) {
            daysLeft[i] = (int) Math.ceil(
                    (double) (100 - progresses[i]) / speeds[i]);
        }
        
        ArrayList<Integer> ret = new ArrayList<>();
        
        int i, j;
        for (i = 0, j = 0; i < numFeat && j < numFeat; j++) {
            if (daysLeft[i] < daysLeft[j]) {
                ret.add(j - i);
                i = j;
            }
        }
        ret.add(j - i);
        
        return ret;
    }
}