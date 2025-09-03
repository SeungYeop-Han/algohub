import java.util.ArrayList;

class Solution {
    
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> ret = new ArrayList<>();
        
        int prev = -1;
        for (int e : arr) {
            if (e != prev) {
                ret.add(e);
                prev = e;
            }
        }
        
        return ret.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}